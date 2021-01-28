package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bmi")
public class BmiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = null;
        //1.接收客户端的数据
        String name = request.getParameter("name");
        Double weight = Double.valueOf(request.getParameter("weight"));
        Double height = Double.valueOf(request.getParameter("height"));
        Double bmi = weight / (height * height);
        //2.进行计算
        if(bmi<18.5){
            msg = "过瘦";
        }else if(bmi >= 18.5 && bmi < 23.9){
            msg = "正常";
        }else if(bmi >= 23.9 && bmi <= 27){
            msg = "过重";
        }else if(bmi > 27 && bmi < 32){
            msg = "肥胖";
        }else{
            msg = "非常肥胖";
        }
        //3.进行返回数据(AJAX的情况下),并跳转显示数据(非AJAX的情况下)
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(name+",您当前的健康状况是"+msg+",请您注意饮食.");
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
