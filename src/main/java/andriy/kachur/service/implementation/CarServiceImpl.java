package andriy.kachur.service.implementation;

import andriy.kachur.dao.CarDao;
import andriy.kachur.dao.implementation.CarDaoImpl;
import andriy.kachur.model.Car;
import andriy.kachur.model.Order;
import andriy.kachur.service.CarService;

import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CarService {
    CarDao carDao = new CarDaoImpl();
    @Override
    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public Car getCarForOrder(Order order) {
        return carDao.getCarForOrder(order);
    }

    @Override
    public void updateCarState(Car car, String newState) {
        carDao.updateCarState(car, newState);
    }

    @Override
    public void createCar(Car car) throws SQLException {
        carDao.createCar(car);
    }

    @Override
    public int numberCarsByCreteriaForOrder(Order order, String creteria) {
        return carDao.numberCarsByCreteriaForOrder(order, creteria);
    }
}
