package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OneServlet")
public class OneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String str = "hello servlet";

        PrintWriter out = response.getWriter();
        out.write(str);*/

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        System.out.println("method="+method);
        System.out.println("url="+url);

        String uri = request.getRequestURI();
        System.out.println("uri"+uri);
    }
}
