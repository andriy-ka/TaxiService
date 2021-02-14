package andriy.kachur.service.implementation;

import andriy.kachur.dao.OrderDao;
import andriy.kachur.dao.implementation.OrderDaoImpl;
import andriy.kachur.model.Car;
import andriy.kachur.model.Order;
import andriy.kachur.model.User;
import andriy.kachur.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public List<Order> getAllUserOrders(User user) {
        return orderDao.getAllUserOrders(user);
    }

    @Override
    public List<Order> getAllCarOrders(Car car) {
        return orderDao.getAllCarOrders(car);
    }

    @Override
    public void createOrder(Order order){
        orderDao.createOrder(order);
    }

    @Override
    public Order getOrderById(int id) throws SQLException {
        return orderDao.getOrderById(id);
    }
}
