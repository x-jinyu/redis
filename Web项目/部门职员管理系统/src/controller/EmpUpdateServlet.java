package controller;

import dao.EmpDao;
import entity.Emp;
import util.ReflectUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpUpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDao dao = new EmpDao();
        Emp emp = null;
        int flag = 0;
        try {
            //1.调用请求对象读取【请求头】中参数信息，得到需要修改的员工的编号
            emp = (Emp) ReflectUtil.init(request,Emp.class);
            //2.调用DeptDao将delete命令推送到数据库服务器执行
            flag = dao.empUpdate(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.调用响应对象将处理结果写入到响应体
        if (flag == 1) {
            request.setAttribute("info", "职员修改成功");
        } else {
            request.setAttribute("info", "职员修改失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
