package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession();

        Object object=httpSession.getAttribute("currentUser");
        String path = httpServletRequest.getServletPath();
        if(null == object&&path.indexOf("login")<0){//用户未登录或者登录超时
            httpServletRequest.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
        }else{//用户已经登录
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
