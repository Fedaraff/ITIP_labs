package Lab_3;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNumber;
    private List<String> products;
    private String deliveryAddress;
    private double totalPrice;
    private String status;

    public Order(String orderNumber, List<String> products, String deliveryAddress, double totalPrice) {
        this.orderNumber = orderNumber;
        this.products = new ArrayList<>(products);
        this.deliveryAddress = deliveryAddress;
        this.totalPrice = totalPrice;
        this.status = "Обрабатывается";
    }

    // Геттеры и сеттеры
    public String getOrderNumber() {
        return orderNumber;
    }

    public List<String> getProducts() {
        return new ArrayList<>(products);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", products=" + products +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Order other = (Order) obj;
        return this.orderNumber.equals(other.orderNumber);
    }

    @Override
    public int hashCode() {
        return orderNumber.hashCode();
    }
}