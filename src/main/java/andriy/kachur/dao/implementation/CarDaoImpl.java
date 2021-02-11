package andriy.kachur.dao.implementation;

import andriy.kachur.config.DBManager;
import andriy.kachur.dao.CarDao;
import andriy.kachur.model.Car;
import andriy.kachur.model.Order;

import java.sql.*;

public class CarDaoImpl implements CarDao {
    private DBManager dbManager = DBManager.getInstance();

    @Override
    public Car getCarById(int id){
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
            }
        } catch (SQLException e) {
            System.err.println("Can not find car with id = " + id);
        }
        return car;
    }

    @Override
    public Car getCarForOrder(Order order){
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
            }
        } catch (SQLException e) {
            System.err.println("We have no car for this order: " + order);
            return new Car();
        }
        return car;
    }
    @Override
    public void updateCarState(Car car, String newState){
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

}
