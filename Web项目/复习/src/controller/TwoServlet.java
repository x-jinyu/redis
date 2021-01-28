package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet处理请求中后半部分内容");

        /*//1.向tomcat索要当前网站中全局作用域对象
        ServletContext application = request.getServletContext();
        Integer key1 =(Integer) application.getAttribute("key1");
        System.out.println("key1 = " + key1);*/


        /*//1.通过请求对象读取请求头中cookie信息
        Cookie[] cookiesArray = request.getCookies();

        //2.读取cookie中信息得到OneServlet提供的共享数据
        for (Cookie card : cookiesArray) {
            String Key = card.getName();
            String value = card.getValue();
            System.out.println(Key +":"+value);
        }*/

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.向tomcat索要当前用户的私人储物柜
        HttpSession session = request.getSession(false);
        //2。将用户选购商品展示出来
        Enumeration goodsNames = session.getAttributeNames();
        while (goodsNames.hasMoreElements()){
            String goodsName =(String) goodsNames.nextElement();
            Integer goodsNum =(Integer) session.getAttribute(goodsName);
            out.print(goodsName +" : " + goodsNum + "<br/>");
        }
    }
}
