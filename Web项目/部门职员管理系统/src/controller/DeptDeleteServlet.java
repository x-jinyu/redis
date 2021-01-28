package controller;

import dao.DeptDao;
import entity.Dept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeptDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptNo = null;
        DeptDao dao = new DeptDao();
        Dept dept = null;
        int flag = 0;
        PrintWriter out = null;

        //1.调用请求对象读取【请求头】中参数信息，得到需要被删除的部门的编号
        deptNo = request.getParameter("deptNo");

        //2.调用DeptDao将delete命令推送到数据库服务器执行
        dept = new Dept(Integer.valueOf(deptNo), null, null);
        try {
            flag = dao.deptDelete(dept);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用响应对象将处理结果写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (flag ==1){
            out.print("<center><font style='color:red;font-size:40px'>部门删除成功</font></center>");
        }else{
            out.print("<center><font style='color:red;font-size:40px'>部门删除失败</font></center>");
        }
    }
}
