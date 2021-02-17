package andriy.kachur.service;

import andriy.kachur.model.Car;
import andriy.kachur.model.City;
import andriy.kachur.model.Order;
import andriy.kachur.model.User;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    List<Order> getAllUserOrders(User user);

    List<Order> getAllCarOrders(Car car);

    List<Order> getAllOrdersByDate(String date);

    void createOrder(Order order);

    Order getOrderById(int id) throws SQLException;

    List<City> getAllCities();

    City getCityByName(String name);

    double distance(double lat1, double lon1, double lat2, double lon2);

}
