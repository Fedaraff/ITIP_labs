package Lab_6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price + " руб.";
    }
}

public class SalesTracker {
    private List<Product> sales = new ArrayList<>();

    public void addSale(String name, double price) {
        sales.add(new Product(name, price));
        System.out.println("Добавлен: " + name + " за " + price + " руб.");
    }

    public void showSales() {
        System.out.println("\nСписок проданных товаров:");
        if (sales.isEmpty()) {
            System.out.println("Нет продаж");
            return;
        }
        for (int i = 0; i < sales.size(); i++) {
            System.out.println((i + 1) + ". " + sales.get(i));
        }
    }

    // Посчитать общую сумму продаж
    public double getTotalSales() {
        double total = 0;
        for (Product product : sales) {
            total += product.getPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        if (sales.isEmpty()) {
            return "Нет продаж";
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (Product product : sales) {
            String name = product.getName();
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }

        String popular = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                popular = entry.getKey();
            }
        }

        return popular + " (продано " + maxCount + " раз)";
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSale("Яблоки", 50.0);
        tracker.addSale("Хлеб", 30.0);
        tracker.addSale("Молоко", 80.0);
        tracker.addSale("Яблоки", 50.0);
        tracker.addSale("Молоко", 80.0);
        tracker.addSale("Молоко", 80.0);

        tracker.showSales();
        System.out.println("\nОбщая сумма: " + tracker.getTotalSales() + " руб.");
        System.out.println("Самый популярный: " + tracker.getMostPopularProduct());
    }
}