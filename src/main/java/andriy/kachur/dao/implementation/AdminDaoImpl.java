package andriy.kachur.dao.implementation;

import andriy.kachur.config.DBManager;
import andriy.kachur.dao.AdminDao;
import andriy.kachur.model.Order;
import andriy.kachur.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private DBManager dbManager = DBManager.getInstance();

    @Override
    public List<Order> sortByDate(String method) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "select * from orders order by date desc;";
        if(method.equals("growing")){
            query = "select * from orders order by date;";
        }
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setShippingAddress(resultSet.getString(2));
                order.setDestinationAddress(resultSet.getString(3));
                order.setNumberOfPassengers(resultSet.getInt(4));
                order.setCategoryOfCar(resultSet.getString(5));
                order.setDate(resultSet.getDate(6));
                order.setPrice(resultSet.getBigDecimal(7));
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public List<Order> sortByPrice(String method) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "select * from orders order by price desc;";
        if(method.equals("growing")){
            query = "select * from orders order by price;";
        }
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setShippingAddress(resultSet.getString(2));
                order.setDestinationAddress(resultSet.getString(3));
                order.setNumberOfPassengers(resultSet.getInt(4));
                order.setCategoryOfCar(resultSet.getString(5));
                order.setDate(resultSet.getDate(6));
                order.setPrice(resultSet.getBigDecimal(7));
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public List<Order> findOrdersByUser(User user) throws SQLException {
//        List<Order> orders = new ArrayList<>();
//        String query = "select * from orders where ";
//        if(method.equals("growing")){
//            query = "select * from orders order by price;";
//        }
//        try (Connection con = dbManager.getConnection();
//             Statement statement = con.createStatement();
//             ResultSet resultSet = statement.executeQuery(query)) {
//            while (resultSet.next()) {
//                Order order = new Order();
//                order.setId(resultSet.getInt(1));
//                order.setShippingAddress(resultSet.getString(2));
//                order.setDestinationAddress(resultSet.getString(3));
//                order.setNumberOfPassengers(resultSet.getInt(4));
//                order.setCategoryOfCar(resultSet.getString(5));
//                order.setDate(resultSet.getDate(6));
//                order.setPrice(resultSet.getDouble(7));
//                orders.add(order);
//            }
//        }
//        return orders;
        return null;
    }

    @Override
    public List<Order> findOrdersByDate(Date date) {
        return null;
    }

    @Override
    public User getUserById(int id){
        User user = new User();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users where id = '" + id + "';")) {
            while (resultSet.next()) {
                user.setId(id);
                user.setLogin(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setSurname(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                user.setRole_id(resultSet.getInt(7));
            }
        }catch (SQLException e){
            System.err.println("No such user");
            return null;
        }
        return user;
    }
    @Override
    public User getUser(String login, String password){
        User user = new User();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users where login = '" + login + "' and password = '" + password + "';")) {
            while (resultSet.next()) {
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(6));
                user.setRole_id(resultSet.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int getUserId(String login, String password){
        User user = new User();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users where login = '" + login + "' and password = '" + password + "';")) {
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(6));
            }
        } catch (SQLException e) {
            System.err.println("Can not get user with login = " + login + " and password = " + password);
        }
        return user.getId();
    }

    @Override
    public void createUser(User user) throws SQLException {
        try (Connection con = dbManager.getConnection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO users (login, email, name, surname, password, role_id) values (?,?,?,?,?,?)")) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getRole_id());
            statement.executeUpdate();
        }
    }

    @Override
    public String getRole(int role_id){
        String role = "null";
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT role FROM roles where id = '" + role_id + "';")) {
            while (resultSet.next()) {
                role = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}
