package controller;

import dao.DeptDao;
import entity.Dept;
import util.ReflectUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeptAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptDao dao = new DeptDao();
        Dept dept = null;
        int flag = 0;
        PrintWriter out = null;

        try {
            //1.调用请求对象读取【请求头】参数信息。得到新部门信息
            dept =(Dept) ReflectUtil.init(request,Dept.class);

            //2.调用DeptDao对象生成insert命令并推送到数据库服务器执行
            flag = dao.insertDept(dept);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.调用响应对象将处理结果写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (flag ==1){
            out.print("<center><font style='color:red;font-size:40px'>部门注册成功</font></center>");
        }else{
            out.print("<center><font style='color:red;font-size:40px'>部门注册失败</font></center>");
        }
    }
}
