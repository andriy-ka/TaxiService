package andriy.kachur.dao.implementation;

import andriy.kachur.config.DBManager;
import andriy.kachur.dao.CarDao;
import andriy.kachur.model.Car;
import andriy.kachur.model.City;
import andriy.kachur.model.Order;
import andriy.kachur.service.OrderService;
import andriy.kachur.service.implementation.OrderServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CarDaoImpl implements CarDao {
    private DBManager dbManager = DBManager.getInstance();
    OrderService orderService = new OrderServiceImpl();

    @Override
    public Car getCarById(int id) {
        Car car = new Car();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM cars where id = '" + id + "';")) {
            while (resultSet.next()) {
                car.setId(id);
                car.setModel(resultSet.getString(2));
                car.setCategory(resultSet.getString(3));
                car.setState(resultSet.getString(4));
                car.setPlaces(resultSet.getInt(5));
                List<Order> orders = orderService.getAllCarOrders(car);
            }
        } catch (SQLException e) {
            System.err.println("Can not find car with id = " + id);
        }
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM cars;")) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(1));
                car.setModel(resultSet.getString(2));
                car.setCategory(resultSet.getString(3));
                car.setState(resultSet.getString(4));
                car.setPlaces(resultSet.getInt(5));
                cars.add(car);
            }
        } catch (SQLException e) {
            System.err.println("#getAllCars");
        }
        return cars;
    }

    @Override
    public Car getCarForOrder(Order order) {
        Car car = new Car();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM cars where category = '" + order.getCategoryOfCar() + "' and places >= '" + order.getNumberOfPassengers() + "' and state = 'AVAILABLE';")) {
            while (resultSet.next()) {
                car.setId(resultSet.getInt(1));
                car.setModel(resultSet.getString(2));
                car.setCategory(resultSet.getString(3));
                car.setState(resultSet.getString(4));
                car.setPlaces(resultSet.getInt(5));
                if(validationByTime(car)){
                    return car;
                }
            }
        } catch (SQLException e) {
            System.err.println("We have no car for this order: " + order);
            return new Car();
        }
        return new Car();
    }

    @Override
    public void updateCarState(Car car, String newState) {
        try (Connection con = dbManager.getConnection();
             PreparedStatement statement = con.prepareStatement("UPDATE cars set state = ? where id = '" + car.getId() + "';")) {
            statement.setString(1, newState);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Can not update car state...");
        }
    }

    @Override
    public void createCar(Car car) throws SQLException {
        try (Connection con = dbManager.getConnection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO cars (model, category, state, places) values (?,?,?,?)")) {
            statement.setString(1, car.getModel());
            statement.setString(2, car.getCategory());
            statement.setString(3, car.getState());
            statement.setInt(4, car.getPlaces());
            statement.executeUpdate();
        }
    }

    public boolean validationByTime(Car car) {
        List<Order> orders = orderService.getAllCarOrders(car);
        boolean result = true;
        for (Order o : orders) {
            City shCity = orderService.getCityByName(o.getShippingAddress());
            City desCity = orderService.getCityByName(o.getDestinationAddress());
            Calendar c = Calendar.getInstance();
            c.setTime(o.getDate());
            long millisInMinute = 60000;
            Date dateAfterAddHalfHour = new Date((c.getTimeInMillis() + ((long) orderService.distance(shCity.getLatitude(),shCity.getLongitude(),desCity.getLatitude(),desCity.getLongitude()) * millisInMinute)));
            if (new Date().after(dateAfterAddHalfHour)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    @Override
    public int numberCarsByCreteriaForOrder(Order order, String creteria){
        String query = null;
        Car car = new Car();
        int counter = 0;
        if(creteria.equals("category")){
            query = "SELECT * FROM cars where category = '" + order.getCategoryOfCar() + "';";
        }else if(creteria.equals("places")){
            query = "SELECT * FROM cars where places >= '" + order.getNumberOfPassengers() + "';";
        }
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                car.setId(resultSet.getInt(1));
                car.setModel(resultSet.getString(2));
                car.setCategory(resultSet.getString(3));
                car.setState(resultSet.getString(4));
                car.setPlaces(resultSet.getInt(5));
                if(validationByTime(car)) {
                    counter++;
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return counter;
    }
}
