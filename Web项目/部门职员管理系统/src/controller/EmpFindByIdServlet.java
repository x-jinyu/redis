package controller;

import dao.EmpDao;
import entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpFindByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empNo = null;
        EmpDao dao = new EmpDao();
        Emp emp = null;
        //1.调用请求对象读取参数，得到职员编号
        empNo = request.getParameter("empNo");
        //2.调用Dao得到职员详细信息
        try {
            emp = dao.findById(empNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用emp_update.jsp输出职员信息
        request.setAttribute("key",emp);
        request.getRequestDispatcher("/emp_update.jsp").forward(request,response);
    }
}
