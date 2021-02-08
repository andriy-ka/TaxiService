package andriy.kachur.dao;

import andriy.kachur.model.Order;
import andriy.kachur.model.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface AdminDao {
    List<Order> sortByDate(String order) throws SQLException;
    List<Order> sortByPrice(String order) throws SQLException;
    List<Order> findOrdersByUser(User user) throws SQLException;
    List<Order> findOrdersByDate(Date date);
    User getUserById(int id) throws SQLException;
    User getUser(String name, String password) throws SQLException;

    int getUserId(String login, String password);

    void createUser(User user) throws SQLException;

    String getRole(int role_id);
}
