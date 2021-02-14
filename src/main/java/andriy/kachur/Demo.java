package andriy.kachur;


import andriy.kachur.dao.OrderDao;
import andriy.kachur.dao.implementation.CarDaoImpl;
import andriy.kachur.dao.implementation.OrderDaoImpl;
import andriy.kachur.model.Order;
import andriy.kachur.service.AdminService;
import andriy.kachur.service.OrderService;
import andriy.kachur.service.implementation.AdminServiceImpl;
import andriy.kachur.service.implementation.OrderServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo {
    static final long ONE_MINUTE_IN_MILLIS=60000;
    public static void main(String[] args) {
        CarDaoImpl carDao = new CarDaoImpl();
        OrderService orderService = new OrderServiceImpl();
        AdminService adminService = new AdminServiceImpl();
        OrderDao orderDao = new OrderDaoImpl();
//        Order order = orderService.getAllUserOrders(adminService.getUserById(1)).get(0);
//        System.out.println(order.getDate());
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar c = Calendar.getInstance();
//        c.setTime(order.getDate());
//        long t = c.getTimeInMillis();
//        Date dateAfterAddTenMin = new Date(t + (30 * ONE_MINUTE_IN_MILLIS));
//        System.out.println(simpleDateFormat.format(dateAfterAddTenMin));
//        System.out.println(new Date().after(dateAfterAddTenMin));
//        System.out.println(orderDao.getAllCarOrders(carDao.getCarById(3)));


        System.out.println(carDao.validationByTime(carDao.getCarById(1)));
        System.out.println(carDao.validationByTime(carDao.getCarById(2)));
        System.out.println(carDao.validationByTime(carDao.getCarById(3)));
    }
}
