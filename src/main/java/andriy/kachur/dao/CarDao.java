package andriy.kachur.dao;

import andriy.kachur.model.Car;
import andriy.kachur.model.User;

import java.sql.SQLException;

public interface CarDao {
    Car getCarById(int id) throws SQLException;
    void createCar(Car car) throws SQLException;
}
