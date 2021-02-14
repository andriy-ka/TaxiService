package andriy.kachur.dao.implementation;

import andriy.kachur.config.DBManager;
import andriy.kachur.dao.OrderDao;
import andriy.kachur.model.Car;
import andriy.kachur.model.Order;
import andriy.kachur.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private DBManager dbManager = DBManager.getInstance();

    @Override
    public List<Order> getAllUserOrders(User user){
        List<Order> orders = new ArrayList<>();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where user_id = '" + user.getId() + "' ORDER BY date DESC ;")) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setShippingAddress(resultSet.getString(2));
                order.setDestinationAddress(resultSet.getString(3));
                order.setNumberOfPassengers(resultSet.getInt(4));
                order.setCategoryOfCar(resultSet.getString(5));
                order.setDate(resultSet.getTimestamp(6));
                order.setPrice(resultSet.getBigDecimal(7));
                orders.add(order);

            }
        } catch (SQLException e) {
            System.err.println("No orders for user = " + user.getLogin());
        }
        return orders;
    }

    @Override
    public List<Order> getAllCarOrders(Car car){
        List<Order> orders = new ArrayList<>();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where car_id = '" + car.getId() + "';")) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setShippingAddress(resultSet.getString(2));
                order.setDestinationAddress(resultSet.getString(3));
                order.setNumberOfPassengers(resultSet.getInt(4));
                order.setCategoryOfCar(resultSet.getString(5));
                order.setDate(resultSet.getTimestamp(6));
                order.setPrice(resultSet.getBigDecimal(7));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println("No orders for user = " + car.getId());
        }
        return orders;
    }

    @Override
    public void createOrder(Order order){
        try (Connection con = dbManager.getConnection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO orders (shippingAddress, destinationAddress, numberOfPassengers, categoryOfCar, date, price, user_id, car_id) values (?,?,?,?,?,?,?,?)")) {
            statement.setString(1, order.getShippingAddress());
            statement.setString(2, order.getDestinationAddress());
            statement.setInt(3, order.getNumberOfPassengers());
            statement.setString(4, order.getCategoryOfCar());
            statement.setObject(5, new java.sql.Timestamp(order.getDate().getTime()));
            statement.setBigDecimal(6, order.getPrice());
            statement.setInt(7, order.getUser_id());
            statement.setInt(8, order.getCar_id());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Can not create order: " + order);
        }
    }

    @Override
    public Order getOrderById(int id) throws SQLException {
        Order order = new Order();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where id = '" + id + "';")) {
            while (resultSet.next()) {
                order.setId(id);
                order.setShippingAddress(resultSet.getString(2));
                order.setDestinationAddress(resultSet.getString(3));
                order.setNumberOfPassengers(resultSet.getInt(4));
                order.setCategoryOfCar(resultSet.getString(5));
                order.setDate(resultSet.getDate(6));
                order.setPrice(resultSet.getBigDecimal(7));
            }
        }
        return order;
    }

}
