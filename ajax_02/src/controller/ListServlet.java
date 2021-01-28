package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.构建学生对象
        Student stu1 = new Student("张三", 21);
        Student stu2 = new Student("李四", 22);
        Student stu3 = new Student("王五", 23);
        Student stu4 = new Student("赵六", 24);

        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        //2.将学生对象转为JSON串,得借助于JSON工具类,导入相应的jar包才可以调用功能
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(list);
        System.out.println(json);
        //3.返回到客户端
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(json);
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
