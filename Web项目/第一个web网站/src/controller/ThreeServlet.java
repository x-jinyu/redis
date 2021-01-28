package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ThreeServlet")
public class ThreeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String str1 ="JAVA<BR/>MYSQL<BR/>HTML<br/>";
        String str2="炸鸡腿<br/>糖醋里脊";

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(str1);
        out.print(str2);*/

        /*String value = request.getParameter("param");
        System.out.println("value = "+value);*/

        String[] array = request.getParameterValues("param");
        for(String value:array){
            System.out.println("value = "+value);
        }
    }
}
