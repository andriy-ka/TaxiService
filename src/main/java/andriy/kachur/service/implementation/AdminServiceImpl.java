package andriy.kachur.service.implementation;

import andriy.kachur.dao.implementation.AdminDaoImpl;
import andriy.kachur.model.Order;
import andriy.kachur.model.User;
import andriy.kachur.service.AdminService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDaoImpl adminDao = new AdminDaoImpl();

    @Override
    public User getUserById(int id) {
        return adminDao.getUserById(id);
    }

    @Override
    public void createUser(User user) throws SQLException {
        adminDao.createUser(user);
    }

    @Override
    public User getUser(String name, String password){
        return adminDao.getUser(name, password);
    }

    @Override
    public int getUserId(String login, String password) {
        return adminDao.getUserId(login, password);
    }

    @Override
    public String getRole(int role_id) {
        return adminDao.getRole(role_id);
    }

    @Override
    public User getUser(String login) {
        return adminDao.getUser(login);
    }
}
