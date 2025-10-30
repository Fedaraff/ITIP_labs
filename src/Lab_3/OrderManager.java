package Lab_3;

import java.util.List;

public class OrderManager {
    private HashTable<String, Order> orders;

    public OrderManager() {
        orders = new HashTable<>();
    }

    public void addOrder(String orderNumber, List<String> products, String deliveryAddress, double totalCost) {
        Order order = new Order(orderNumber, products, deliveryAddress, totalCost);
        orders.put(orderNumber, order);
    }

    public Order getOrder(String orderNumber) {
        return orders.get(orderNumber);
    }

    public void removeOrder(String orderNumber) {
        orders.remove(orderNumber);
    }

    public int getOrderCount() {
        return orders.size();
    }

    public boolean hasOrders() {
        return !orders.isEmpty();
    }

    private static class Order {
        private String orderNumber;
        private List<String> products;
        private String deliveryAddress;
        private double totalCost;

        public Order(String orderNumber, List<String> products, String deliveryAddress, double totalCost) {
            this.orderNumber = orderNumber;
            this.products = products;
            this.deliveryAddress = deliveryAddress;
            this.totalCost = totalCost;
        }

        @Override
        public String toString() {
            return String.format("Заказ %s: %s | Адрес: %s | Сумма: %.2f руб.",
                    orderNumber, products, deliveryAddress, totalCost);
        }
    }
}