package andriy.kachur.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/adminHome")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        //Существует ли сессиия
        boolean loggedIn = session != null && session.getAttribute("userName") != null && session.getAttribute("userRole") != null;
        if (loggedIn ){
            //Если существует то получаем роль
            String userRole = session.getAttribute("userRole").toString();
            if (userRole.equals("USER")){
                response.sendRedirect(request.getContextPath() + "home");
            }else if (userRole.equals("ADMIN")){
                filterChain.doFilter(request, response);
            }
            //Если нет то на страницу входа.
        }else response.sendRedirect(request.getContextPath() + "login");
    }

    @Override
    public void destroy() {

    }
}

