package andriy.kachur.dao.implementation;

import andriy.kachur.config.DBManager;
import andriy.kachur.dao.CarDao;
import andriy.kachur.model.Car;

import java.sql.*;

public class CarDaoImpl implements CarDao {
    private DBManager dbManager = DBManager.getInstance();

    @Override
    public Car getCarById(int id) throws SQLException {
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
        }
        return car;
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
