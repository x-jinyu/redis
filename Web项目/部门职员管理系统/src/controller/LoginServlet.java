package controller;

import dao.EmpDao;
import entity.Emp;
import util.ReflectUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookieArray = null;
        Emp emp = null;
        String ck = null;
        EmpDao dao = new EmpDao();
        int flag = 0;
        String loginName = null;
        String loginPassword = null;
        HttpSession session = null;
        //1.调用请求对象读取请求头中cookie
        cookieArray = request.getCookies();
        //2.调用请求对象使用utf-8字符集解析请求体参数
        request.setCharacterEncoding("utf-8");
        //3.调用请求对象读取请求体参数信息
        try {
            emp = (Emp) ReflectUtil.init(request, Emp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ck = request.getParameter("ck");
        //4.对于主动提供用户名和密码用户，到数据库进行身份验证
        if (emp.getEmpNo() != null && emp.getEname() != null) {
            try {
                flag = dao.login(emp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (flag > 0) {
                if (ck != null) {
                    Cookie card = new Cookie(emp.getEname(), "大族门禁卡");
                    card.setMaxAge(60 * 60 * 24 * 10);
                    response.addCookie(card);
                }
                //为合法用户申请令牌
                session = request.getSession();
                session.setAttribute("key", "裤衩");
                request.getRequestDispatcher("/index.html").forward(request, response);
                return;
            }
        }
        //5.对于提供会员卡用户根据是否拥有"大族会员卡"进行验证
        if (cookieArray != null) {
            for (Cookie card : cookieArray) {
                if ("大族门禁卡".equals(card.getValue())) {
                    //为合法用户申请令牌
                    session = request.getSession();
                    session.setAttribute("key", "裤衩");
                    request.getRequestDispatcher("index.html").forward(request, response);
                    return;
                }
            }
        }
        //6 对于第一次来访的用户，应该通知tomcat将login.html文件写入到响应体
        loginName = request.getParameter("ename");
        loginPassword = request.getParameter("empNo");
        if (loginName == null && loginPassword == null) {
            request.getRequestDispatcher("/login.html").forward(request, response);
            return;
        }
        //7.对于用户名和密码不存在或则无法提供任何证件用户拒绝进入
        request.getRequestDispatcher("login_error.html").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
