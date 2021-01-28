package controller;

import dao.EmpDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmpFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDao dao = new EmpDao();
        List empList = null;
        //1.调用EmpDao查询职员信息
        try {
            empList = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2.将职员信息存入到请求作用域对象
        request.setAttribute("key",empList);
        //3.请求转发调用emp_find.jsp
        request.getRequestDispatcher("/emp_find.jsp").forward(request,response);
    }
}
