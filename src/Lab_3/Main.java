package Lab_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();

        System.out.println("=== Демонстрация работы системы заказов ===\n");

        // Добавление заказов
        System.out.println("1. Добавляем заказы:");
        manager.addOrder("ORD001", Arrays.asList("Ноутбук", "Мышь"), "Москва, ул. Ленина, 1", 75000.0);
        manager.addOrder("ORD002", Arrays.asList("Клавиатура", "Наушники"), "СПб, Невский пр., 50", 15000.0);
        manager.addOrder("ORD003", Arrays.asList("Монитор 24\"", "Кабель HDMI"), "Екатеринбург, ул. Мира, 25", 32000.0);

        System.out.println("Количество заказов: " + manager.getOrderCount());
        System.out.println("Есть ли заказы: " + manager.hasOrders());

        // Поиск заказов
        System.out.println("\n2. Поиск заказов:");
        System.out.println(manager.getOrder("ORD001"));
        System.out.println(manager.getOrder("ORD002"));

        // Попытка поиска несуществующего заказа
        System.out.println("\n3. Поиск несуществующего заказа:");
        System.out.println("Заказ ORD999: " + manager.getOrder("ORD999"));

        // Обновление заказа (добавление с тем же номером)
        System.out.println("\n4. Обновление заказа ORD002:");
        manager.addOrder("ORD002", Arrays.asList("Игровая клавиатура", "Геймпад"), "СПб, Невский пр., 50", 25000.0);
        System.out.println(manager.getOrder("ORD002"));

        // Удаление заказа
        System.out.println("\n5. Удаление заказа ORD003:");
        manager.removeOrder("ORD003");
        System.out.println("Количество заказов после удаления: " + manager.getOrderCount());

        // Попытка удаления несуществующего заказа
        System.out.println("\n6. Удаление несуществующего заказа:");
        manager.removeOrder("ORD999");
        System.out.println("Количество заказов: " + manager.getOrderCount());

        // Финальное состояние
        System.out.println("\n7. Финальное состояние:");
        System.out.println("Количество заказов: " + manager.getOrderCount());
        System.out.println("Есть ли заказы: " + manager.hasOrders());
    }
}