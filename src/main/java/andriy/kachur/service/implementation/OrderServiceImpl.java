package andriy.kachur.service.implementation;

import andriy.kachur.dao.OrderDao;
import andriy.kachur.dao.implementation.OrderDaoImpl;
import andriy.kachur.model.Car;
import andriy.kachur.model.City;
import andriy.kachur.model.Order;
import andriy.kachur.model.User;
import andriy.kachur.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public List<Order> getAllUserOrders(User user) {
        return orderDao.getAllUserOrders(user);
    }

    @Override
    public List<Order> getAllCarOrders(Car car) {
        return orderDao.getAllCarOrders(car);
    }

    @Override
    public List<Order> getAllOrdersByDate(String date) {
        return orderDao.getAllOrdersByDate(date);
    }

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public Order getOrderById(int id) throws SQLException {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<City> getAllCities() {
        return orderDao.getAllCities();
    }

    @Override
    public City getCityByName(String name) {
        return orderDao.getCityByName(name);
    }

    @Override
    public double distance(double lat1, double lon1, double lat2, double lon2) {
        return orderDao.distance(lat1, lon1, lat2, lon2);
    }


}
