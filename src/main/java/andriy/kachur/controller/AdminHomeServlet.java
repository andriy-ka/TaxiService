package andriy.kachur.controller;

import andriy.kachur.model.Order;
import andriy.kachur.service.AdminService;
import andriy.kachur.service.OrderService;
import andriy.kachur.service.implementation.AdminServiceImpl;
import andriy.kachur.service.implementation.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/adminHome")
public class AdminHomeServlet extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("name", session.getAttribute("name"));
        req.setAttribute("orders", orderService.getAllOrders());
        controllerForSort(req, resp);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminHome.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void controllerForSort(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.getAllOrders();
        if (req.getParameter("sort") == null || req.getParameter("sort").equals("Desc")) {
            Comparator<Order> dateOrderA = (o1, o2) -> o2.getDate().compareTo(o1.getDate());
            orders.sort(dateOrderA);
            req.setAttribute("orders", orders);
        } else if (req.getParameter("sort").equals("Asc")) {
            Comparator<Order> dateOrderA = (o1, o2) -> o1.getDate().compareTo(o2.getDate());
            orders.sort(dateOrderA);
            req.setAttribute("orders", orders);
        }
        if (req.getParameter("userLogin") != null) {
            String userLogin = req.getParameter("userLogin");
            List<Order> orderList = orderService.getAllUserOrders(adminService.getUser(userLogin));
            if (orderList.isEmpty()) {
                orderList = orderService.getAllOrders();
            }
            req.setAttribute("orders", orderList);
        }
        if (req.getParameter("date") != null) {
            String date = req.getParameter("date");
            List<Order> orderList = orderService.getAllOrdersByDate(date);
            if (orderList.isEmpty()) {
                orderList = orderService.getAllOrders();
            }
            req.setAttribute("orders", orderList);
        }

    }
}
