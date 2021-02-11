package andriy.kachur.service;

import andriy.kachur.model.Car;
import andriy.kachur.model.Order;

import java.sql.SQLException;

public interface CarService {
    Car getCarById(int id);

    Car getCarForOrder(Order order);

    void updateCarState(Car car, String newState);

    void createCar(Car car) throws SQLException;
}
