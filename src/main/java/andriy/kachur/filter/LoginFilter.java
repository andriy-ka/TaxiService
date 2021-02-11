package andriy.kachur.filter;

import andriy.kachur.model.User;
import andriy.kachur.service.AdminService;
import andriy.kachur.service.implementation.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    AdminService adminService = new AdminServiceImpl();
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/login";
        String welcomeURI = request.getContextPath() + "/";
        String registrationURI = request.getContextPath() + "/registration";
        boolean loggedIn = false;
        if(session != null && session.getAttribute("userName") != null && session.getAttribute("password") != null) {
             loggedIn = adminService.getUser(session.getAttribute("userName").toString(), session.getAttribute("password").toString()) != null;
        }
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean welcomeRequest = request.getRequestURI().equals(welcomeURI);
        boolean registrationRequest = request.getRequestURI().equals(registrationURI);


        if (loggedIn || loginRequest || welcomeRequest || registrationRequest) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {

    }
}
