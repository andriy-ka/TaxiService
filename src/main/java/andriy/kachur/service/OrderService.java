package andriy.kachur.service;

import andriy.kachur.model.Order;
import andriy.kachur.model.User;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    List<Order> getAllUserOrders(User user);

    void createOrder(Order order);
    Order getOrderById(int id) throws SQLException;
}