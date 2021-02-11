package andriy.kachur.controller;

import andriy.kachur.model.User;
import andriy.kachur.service.AdminService;
import andriy.kachur.service.implementation.AdminServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        int user_id = adminService.getUserId(login, password);
        if(user_id != 0) {
            User user = adminService.getUserById(user_id);
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", login);
            session.setAttribute("name", user.getName());
            session.setAttribute("userRole", adminService.getRole(user.getRole_id()));
            session.setAttribute("password", password);
            if(adminService.getRole(user.getRole_id()).equals("USER")){
                resp.sendRedirect("home");
            }
            if(adminService.getRole(user.getRole_id()).equals("ADMIN")){
                resp.sendRedirect("adminHome");
            }
        }else{
            resp.sendRedirect("login");
            session.setAttribute("userName", null);
            session.setAttribute("password", null);
            session.setAttribute("userRole", null);
            session.setAttribute("userId", null);
            session.setAttribute("name", null);
        }
    }
}
