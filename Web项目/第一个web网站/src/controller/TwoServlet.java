package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "TwoServlet")
public class TwoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*int i = 50;
        PrintWriter out = response.getWriter();
        //out.write(i);
        out.print(i);*/

        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String name =(String) paramNames.nextElement();
            String value = request.getParameter(name);

            System.out.println("请求参数名称 "+name+"  请求参数内容 "+value);
        }

       /* String value = request.getParameter("sex");
        System.out.println("读取不存在的参数的内容 "+value);*/
    }
}
