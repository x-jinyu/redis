package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FourServlet")
public class FourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String value = request.getParameter("param");
        System.out.println("读取请求体中参数内容 "+value);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String url = "http://www.baidu.com?userName=mike&password=123";
        response.sendRedirect(url);*/
        String value = request.getParameter("param");
        System.out.println("读取请求头中参数内容 "+value);

    }
}
