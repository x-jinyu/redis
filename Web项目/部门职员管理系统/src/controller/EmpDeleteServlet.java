package controller;

import dao.EmpDao;
import entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empNo = null;
        Emp emp = null;
        EmpDao dao = new EmpDao();
        int flag = 0;
        //1.调用请求对象读取请求头中参数，得到需要删除的职员编号
        empNo = request.getParameter("empNo");
        //2.调用EmpDao推送delete命令
        emp = new Emp(Integer.valueOf(empNo));
        try {
            flag = dao.empDelete(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用info.jsp将处理结果写入到响应体
        if (flag==1){
            request.setAttribute("info","职员删除成功");
        }else{
            request.setAttribute("info","职员删除失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
