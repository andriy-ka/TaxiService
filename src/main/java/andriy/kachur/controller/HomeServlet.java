package andriy.kachur.controller;

import andriy.kachur.model.City;
import andriy.kachur.model.Order;
import andriy.kachur.service.AdminService;
import andriy.kachur.service.CarService;
import andriy.kachur.service.OrderService;
import andriy.kachur.service.implementation.AdminServiceImpl;
import andriy.kachur.service.implementation.CarServiceImpl;
import andriy.kachur.service.implementation.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    AdminService adminService = new AdminServiceImpl();
    CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Order> orders = orderService.getAllUserOrders(adminService.getUserById((Integer) session.getAttribute("userId")));
        req.setAttribute("name", session.getAttribute("name"));
        req.setAttribute("orders", orders);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        buttonController(req, resp);


    }

    private void buttonController(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getParameter("submitOrder") != null) {
            Order order = orderForm(req, resp);
            req.setAttribute("order", order);
            req.getSession().setAttribute("order", order);
            req.setAttribute("confirmNewOrder", 0);
            req.setAttribute("cities", orderService.getAllCities());
            getServletContext().getRequestDispatcher("/WEB-INF/views/newOrder.jsp").forward(req, resp);
        }
        if (req.getParameter("newOrder") != null) {
            req.setAttribute("name", req.getSession().getAttribute("name"));
            req.setAttribute("cities", orderService.getAllCities());
            getServletContext().getRequestDispatcher("/WEB-INF/views/newOrder.jsp").forward(req, resp);
        }
        if (req.getParameter("confirmNewOrder") != null) {
            Order order = (Order) req.getSession().getAttribute("order");
            int car_id = carService.getCarForOrder(order).getId();
            if(car_id != 0){
                order.setCar_id(carService.getCarForOrder(order).getId());
            }else{
                req.setAttribute("car_id", 0);
                req.setAttribute("cities", orderService.getAllCities());
                getServletContext().getRequestDispatcher("/WEB-INF/views/newOrder.jsp").forward(req, resp);
            }
            orderService.createOrder(order);
            resp.sendRedirect("home");
        }
        if (req.getParameter("denyNewOrder") != null) {
            req.setAttribute("cities", orderService.getAllCities());
            getServletContext().getRequestDispatcher("/WEB-INF/views/newOrder.jsp").forward(req, resp);
        }
        if (req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.setAttribute("userName", null);
            session.setAttribute("userId", null);
            session.setAttribute("name", null);
            session.setAttribute("password", null);
            session.setAttribute("userRole", null);
            resp.sendRedirect("login");
        }
    }

    private Order orderForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        City shippingCity = orderService.getCityByName(req.getParameter("shippingAddress"));
        City destinationAddress = orderService.getCityByName(req.getParameter("destinationAddress"));

        order.setShippingAddress(req.getParameter("shippingAddress"));
        order.setDestinationAddress(req.getParameter("destinationAddress"));
        order.setNumberOfPassengers(Integer.parseInt(req.getParameter("passengers")));
        order.setCategoryOfCar(req.getParameter("category"));
        order.setDate(new Timestamp(new Date().getTime()));

        if(carService.numberCarsByCreteriaForOrder(order, "places") == 0){
            req.setAttribute("numberOfCarByPlaces", 0);
            req.setAttribute("cities", orderService.getAllCities());
            getServletContext().getRequestDispatcher("/WEB-INF/views/newOrder.jsp").forward(req, resp);
        }
        if(carService.numberCarsByCreteriaForOrder(order, "category") == 0){
            req.setAttribute("numberOfCarByCategory", 0);
            req.setAttribute("cities", orderService.getAllCities());
            getServletContext().getRequestDispatcher("/WEB-INF/views/newOrder.jsp").forward(req, resp);
        }

        if(req.getParameter("category").equals("Economy")) {
            order.setPrice(BigDecimal.valueOf(5.5 * orderService.distance(shippingCity.getLatitude(), shippingCity.getLongitude(), destinationAddress.getLatitude(), destinationAddress.getLongitude())));
        }else if(req.getParameter("category").equals("Business")){
            order.setPrice(BigDecimal.valueOf(8 * orderService.distance(shippingCity.getLatitude(), shippingCity.getLongitude(), destinationAddress.getLatitude(), destinationAddress.getLongitude())));
        }

        order.setUser_id(adminService.getUserId(req.getSession().getAttribute("userName").toString(), req.getSession().getAttribute("password").toString()));


        return order;
    }
}
