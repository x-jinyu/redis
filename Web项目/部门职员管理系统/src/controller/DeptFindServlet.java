package controller;

import dao.DeptDao;
import entity.Dept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DeptFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptDao dao = new DeptDao();
        List<Dept> deptList = null;
        PrintWriter out = null;

        //1.调用DeptDao推送查询命令得到所有的部门信息【List<Dept>】
        try {
            deptList = dao.findAllDept();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<script type='text/javascript' src='/myWeb/js/common.js'></script>");
        out.print("<center>");
        out.print("<table border=2>");
        out.print("<tr>");
        out.print("<td><input type='checkbox'/>全选与全不选</td>");
        out.print("<td>部门编号</td>");
        out.print("<td>部门名称</td>");
        out.print("<td>部门位置</td>");
        out.print("<center>");
        out.print("<td colspan=3>操作</td>");
        out.print("</center>");
        out.print("</tr>");
        for (Dept dept : deptList) {
            out.print("<tr>");
            out.print("<td><input type='checkbox'/></td>");
            out.print("<td>"+dept.getDeptNo()+"</td>");
            out.print("<td>"+dept.getDname()+"</td>");
            out.print("<td>"+dept.getLoc()+"</td>");
            out.print("<td><a href='/myWeb/dept/delete?deptNo="+dept.getDeptNo()+"'>部门删除</a></td>");
            out.print("<td><a href='/myWeb/dept/findById?deptNo="+dept.getDeptNo()+"'>部门详细信息</a></td>");
            //out.print("<td><a href='/myWeb/dept/update?deptNo="+dept.getDeptNo()+"'>部门信息修改</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
        out.print("</center>");
    }
}
