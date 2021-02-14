package andriy.kachur.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int id;
    private String shippingAddress;
    private String destinationAddress;
    private int numberOfPassengers;
    private String categoryOfCar;
    private Date date;
    private BigDecimal price;
    private int user_id;
    private int car_id;


    public Order() {
    }

    public Order(String shippingAddress, String destinationAddress, int numberOfPassengers, String categoryOfCar, Date date, BigDecimal price, int user_id, int car_id) {
        this.shippingAddress = shippingAddress;
        this.destinationAddress = destinationAddress;
        this.numberOfPassengers = numberOfPassengers;
        this.categoryOfCar = categoryOfCar;
        this.date = date;
        this.price = price;
        this.user_id = user_id;
        this.car_id = car_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", categoryOfCar='" + categoryOfCar + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", user_id=" + user_id +
                ", car_id=" + car_id +
                '}';
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getCategoryOfCar() {
        return categoryOfCar;
    }

    public void setCategoryOfCar(String categoryOfCar) {
        this.categoryOfCar = categoryOfCar;
    }
}
