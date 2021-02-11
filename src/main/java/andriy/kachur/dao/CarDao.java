package andriy.kachur.dao;

import andriy.kachur.model.Car;
import andriy.kachur.model.Order;
import andriy.kachur.model.User;

import java.sql.SQLException;

public interface CarDao {
    Car getCarById(int id);

    Car getCarForOrder(Order order);

    void updateCarState(Car car, String newState);

    void createCar(Car car) throws SQLException;
}
