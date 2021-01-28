package controller;

import dao.EmpDao;
import entity.Emp;
import util.ReflectUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDao dao = new EmpDao();
        Emp emp = null;
        int flag = 0;

        try {
            //1.调用请求对象读取【请求头】参数信息。得到新职员信息
            emp = (Emp) ReflectUtil.init(request, Emp.class);
            //2.调用EmpDao对象生成insert命令并推送到数据库服务器执行
            flag = dao.insertEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用emp_add.jsp将处理结果写入到响应体
        if (flag == 1) {
            request.setAttribute("emp_add", "职员注册成功");
        } else {
            request.setAttribute("emp_add", "职员注册失败");
        }
        request.getRequestDispatcher("/emp_add.jsp").forward(request, response);
    }
}
