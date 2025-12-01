package Lab_6;

import java.util.*;

public class SalesTracker {
    public static void main(String[] args) {
        Map<String, Integer> sales = new HashMap<>();

        addSale(sales, "Яблоки");
        addSale(sales, "Хлеб");
        addSale(sales, "Молоко");
        addSale(sales, "Яблоки");
        addSale(sales, "Молоко");
        addSale(sales, "Молоко");
        addSale(sales, "Сыр");
        addSale(sales, "Хлеб");

        printSales(sales);

        int totalSales = getTotalSales(sales);
        System.out.println("\nОбщее количество продаж: " + totalSales);

        String popular = getMostPopularProduct(sales);
        System.out.println("Самый популярный товар: " + popular);
    }

    public static void addSale(Map<String, Integer> sales, String product) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
        System.out.println("Продано: " + product);
    }

    public static void printSales(Map<String, Integer> sales) {
        System.out.println("\n=== Отчет о продажах ===");

        if (sales.isEmpty()) {
            System.out.println("Нет данных о продажах");
            return;
        }

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            String product = entry.getKey();
            int count = entry.getValue();
            System.out.println(product + ": продано " + count + " раз");
        }
    }

    public static int getTotalSales(Map<String, Integer> sales) {
        int total = 0;
        for (int count : sales.values()) {
            total += count;
        }

        return total;
    }

    public static String getMostPopularProduct(Map<String, Integer> sales) {
        if (sales.isEmpty()) {
            return "Нет данных";
        }

        String mostPopular = null;
        int maxSales = 0;

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }

        return mostPopular + " (" + maxSales + " продаж)";
    }
}