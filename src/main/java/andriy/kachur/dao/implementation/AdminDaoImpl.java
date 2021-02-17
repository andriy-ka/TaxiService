package andriy.kachur.dao.implementation;

import andriy.kachur.config.DBManager;
import andriy.kachur.dao.AdminDao;
import andriy.kachur.model.User;

import java.sql.*;

public class AdminDaoImpl implements AdminDao {
    private DBManager dbManager = DBManager.getInstance();


    @Override
    public User getUserById(int id) {
        User user = new User();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users where id = '" + id + "';")) {
            while (resultSet.next()) {
                user.setId(id);
                user.setLogin(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setSurname(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                user.setRole_id(resultSet.getInt(7));
            }
        } catch (SQLException e) {
            System.err.println("No such user");
            return null;
        }
        return user;
    }

    @Override
    public User getUser(String login) {
        User user = new User();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users where login = '" + login + "';")) {
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setSurname(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                user.setRole_id(resultSet.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUser(String login, String password) {
        User user = new User();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users where login = '" + login + "' and password = '" + password + "';")) {
            while (resultSet.next()) {
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(6));
                user.setRole_id(resultSet.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int getUserId(String login, String password) {
        User user = new User();
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users where login = '" + login + "' and password = '" + password + "';")) {
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(6));
            }
        } catch (SQLException e) {
            System.err.println("Can not get user with login = " + login + " and password = " + password);
        }
        return user.getId();
    }

    @Override
    public void createUser(User user) throws SQLException {
        try (Connection con = dbManager.getConnection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO users (login, email, name, surname, password, role_id) values (?,?,?,?,?,?)")) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getRole_id());
            statement.executeUpdate();
        }
    }

    @Override
    public String getRole(int role_id) {
        String role = "null";
        try (Connection con = dbManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT role FROM roles where id = '" + role_id + "';")) {
            while (resultSet.next()) {
                role = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}
