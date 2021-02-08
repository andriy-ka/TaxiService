package andriy.kachur.dao;

import andriy.kachur.model.Order;

import java.sql.SQLException;

public interface OrderDao {

    void createOrder(Order order) throws SQLException;
    Order getOrderById(int id) throws SQLException;
}
