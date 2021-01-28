package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 王金宇
 * 2020/11/21 0021
 */
public class SafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request =(HttpServletRequest) servletRequest;
        if ("/login".equals(request.getServletPath())){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        //检测当前用户是否拥有令牌
        HttpSession session = request.getSession(false);

        if (session == null){
            request.getRequestDispatcher("/login_error.html").forward(request,servletResponse);
            return;
        }
        Object value = session.getAttribute("key");
        if (value == null){
            request.getRequestDispatcher("/login_error.html").forward(request,servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
