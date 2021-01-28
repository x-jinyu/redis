package controller;

import dao.DeptDao;
import entity.Dept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeptFindByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptNo = null;
        DeptDao dao = new DeptDao();
        Dept dept = null;
        PrintWriter out = null;

        //1.调用请求对象读取【请求头】中参数，得到需要被检索的部门编号
        deptNo = request.getParameter("deptNo");
        //2.调用DeptDao推送查询语句得到这个编号关联的完整部门信息
        try {
            dept = dao.findById(deptNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用响应对象将部门信息写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<center>");
        out.print("<form action='/myWeb/dept/update'>");
        out.print("<table border=2>");
        out.print("<tr><td>部门编号</td><td><input type='text' name='deptNo' value='"+dept.getDeptNo()+"'/></td></tr>");
        out.print("<tr><td>部门名称</td><td><input type='text' name='dname' value='"+dept.getDname()+"'/></td></tr>");
        out.print("<tr><td>部门位置</td><td><input type='text' name='loc' value='"+dept.getLoc()+"'/></td></tr>");
        out.print("<tr><td><input type='submit' value='部门更新'></td><td><input type='reset' /></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.print("</center>");

    }
}
