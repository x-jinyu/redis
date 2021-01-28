package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet处理请求中前半部分内容");
        /*String url = "http://localhost:8080/myWeb/two";   //01
        String uri = "/myWeb/two";
        response.sendRedirect(url);*/
        //====================================================================================
        /*String servletPath="/two";                        //02
        String src="/html/two.html";
        RequestDispatcher report = request.getRequestDispatcher(src);
        report.forward(request,response);*/
        //====================================================================================
        /*//1.向tomcat索要当前网站中全局作用域对象             //03
        ServletContext application = request.getServletContext();
        //2.将共享数据以key-value形式存入到全局作用域对象
        application.setAttribute("key1",100);*/
        //====================================================================================
        /*//1.创建cookie并写入共享数据                       //04
        Cookie card1 = new Cookie("key1","100");
        Cookie card2 = new Cookie("key2","200");

        //2.设置cookie在客户端计算机硬盘上存活时间为1分钟
        card1.setMaxAge(60);

        //3.将cookie对象写入到响应头
        response.addCookie(card1);  //储存在硬盘中60秒
        response.addCookie(card2);  //储存在浏览器内存中*/
        //====================================================================================

        //1.【询问用户本次选购商品】调用请求对象读取请求头参数
        String goodsName = request.getParameter("goodsName");
        //2.向tomcat索要当前用户的私人储物柜
        HttpSession session = request.getSession();
        //3.将用户商品存入到私人储物柜
        Integer goodsNum = (Integer) session.getAttribute(goodsName);
        if (goodsNum == null) {
            session.setAttribute(goodsName, 1);
        } else {
            session.setAttribute(goodsName, goodsNum + 1);
        }
    }
}
