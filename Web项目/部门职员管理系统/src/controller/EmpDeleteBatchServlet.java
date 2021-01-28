package controller;

import dao.EmpDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpDeleteBatchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] array = null;
        EmpDao dao = new EmpDao();
        int flag = 0;
        //1.调用请求对象读取请求头中参数得到需要被删除的职员编号
        array = request.getParameterValues("empNo");
        //2.调用EmpDao推送批处理删除命令
        try {
            flag = dao.empDeleteBatch(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用info.jsp将输出结果写入到响应体
        if (flag == 1) {
            request.setAttribute("info", "职员删除成功");
        } else {
            request.setAttribute("info", "职员删除失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
