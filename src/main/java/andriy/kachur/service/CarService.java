package andriy.kachur.service;

import andriy.kachur.model.Car;
import andriy.kachur.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface CarService {
    Car getCarById(int id);

    List<Car> getAllCars();

    Car getCarForOrder(Order order);

    void updateCarState(Car car, String newState);

    void createCar(Car car) throws SQLException;

    int numberCarsByCreteriaForOrder(Order order, String creteria);
}
