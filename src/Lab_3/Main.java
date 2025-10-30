package Lab_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();

        System.out.println("1. Добавляем заказы:");
        manager.addOrder("ORD001", Arrays.asList("Ноутбук", "Мышь"), "Москва, ул. Ленина, 1", 75000.0);
        manager.addOrder("ORD002", Arrays.asList("Клавиатура", "Наушники"), "СПб, Невский пр., 50", 15000.0);
        manager.addOrder("ORD003", Arrays.asList("Монитор 24", "Кабель HDMI"), "Екатеринбург, ул. Мира, 25", 32000.0);

        System.out.println("Количество заказов: " + manager.getOrderCount());
        System.out.println("Есть ли заказы: " + manager.hasOrders());

        System.out.println("\n2. Поиск заказов:");
        System.out.println(manager.getOrder("ORD001"));
        System.out.println(manager.getOrder("ORD002"));

        System.out.println("\n3. Поиск несуществующего заказа:");
        System.out.println("Заказ ORD999: " + manager.getOrder("ORD999"));

        System.out.println("\n4. Обновление заказа ORD002:");
        manager.addOrder("ORD002", Arrays.asList("Игровая клавиатура", "Геймпад"), "СПб, Невский пр., 50", 25000.0);
        System.out.println(manager.getOrder("ORD002"));

        System.out.println("\n5. Удаление заказа ORD003:");
        manager.removeOrder("ORD003");
        System.out.println("Количество заказов после удаления: " + manager.getOrderCount());

        System.out.println("\n6. Удаление несуществующего заказа:");
        manager.removeOrder("ORD999");
        System.out.println("Количество заказов: " + manager.getOrderCount());

        System.out.println("\n7. Итог:");
        System.out.println("Количество заказов: " + manager.getOrderCount());
        System.out.println("Есть ли заказы: " + manager.hasOrders());
    }
}