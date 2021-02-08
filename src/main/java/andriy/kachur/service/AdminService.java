package andriy.kachur.service;

import andriy.kachur.model.Order;
import andriy.kachur.model.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface AdminService {
    List<Order> sortByDate(String order) throws SQLException;
    List<Order> sortByPrice(String order) throws SQLException;
    List<Order> findOrdersByUser(User user) throws SQLException;
    List<Order> findOrdersByDate(Date date);
    public User getUserById(int id);
    public void createUser(User user) throws SQLException;
    User getUser(String name, String password);
    int getUserId(String login, String password);
    String getRole(int role_id);
}
