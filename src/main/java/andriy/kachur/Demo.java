package andriy.kachur;

import andriy.kachur.dao.implementation.AdminDaoImpl;
import andriy.kachur.dao.implementation.OrderDaoImpl;
import andriy.kachur.model.Order;
import andriy.kachur.model.User;
import andriy.kachur.service.AdminService;
import andriy.kachur.service.implementation.AdminServiceImpl;

import java.sql.SQLException;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws SQLException {
//        OrderDaoImpl orderDao = new OrderDaoImpl();
//        orderDao.createOrder(new Order("shAddress", "dAddress", 3, "fsdf", new java.sql.Date(new Date().getTime()), 324));
//        orderDao.createOrder(new Order("shAddress1", "dAddress1", 5, "rew", new java.sql.Date(new Date().getTime()), 213));
//        orderDao.createOrder(new Order("shAddress2", "dAddress2", 2, "gfh", new java.sql.Date(new Date().getTime()), 123));
//        System.out.println(orderDao.getOrderById(2));

//        orderDao.setOrderForUser(userDao.getUserById(1), orderDao.getOrderById(2));
//        orderDao.setOrderForUser(userDao.getUserById(3), orderDao.getOrderById(1));
//        orderDao.setOrderForUser(userDao.getUserById(2), orderDao.getOrderById(3));

//        CarDaoImpl carDao = new CarDaoImpl();
//        carDao.createCar(new Car("Tesla X","business","available", 4));
//        carDao.createCar(new Car("Audi A6","business","in the way", 5));
//        carDao.createCar(new Car("Opel","economy","unavailable", 6));
//        System.out.println(carDao.getCarById(3));

        AdminService adminService = new AdminServiceImpl();
//        adminService.createUser(new User("login0","email2","name1","surname10","password1", 2));
        User user = adminService.getUser("andriyk", "12");
        System.out.println(adminService.getRole(user.getRole_id()));
//        System.out.println(adminDao.sortByDate("growing"));
//        System.out.println(adminDao.sortByPrice(""));
    }
}
