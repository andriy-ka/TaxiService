package andriy.kachur.model;

import java.util.Date;

public class Order {
    private int id;
    private String shippingAddress;
    private String destinationAddress;
    private int numberOfPassengers;
    private String categoryOfCar;
    private java.sql.Date date;
    private double price;
    private String user_id;


    public Order() {
    }

    public Order(String shippingAddress, String destinationAddress, int numberOfPassengers, String categoryOfCar, java.sql.Date date, double price, String user_id) {
        this.shippingAddress = shippingAddress;
        this.destinationAddress = destinationAddress;
        this.numberOfPassengers = numberOfPassengers;
        this.categoryOfCar = categoryOfCar;
        this.date = date;
        this.price = price;
        this.user_id = user_id;
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
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(java.sql.Date date) {
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
