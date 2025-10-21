package Lab_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Создаем хэш-таблицу для заказов
        HashTable<String, Order> orderTable = new HashTable<>();

        // Создаем несколько заказов
        Order order1 = new Order("ORD001",
                Arrays.asList("Ноутбук", "Мышь", "Сумка"),
                "ул. Ленина, д. 10", 1500.00);

        Order order2 = new Order("ORD002",
                Arrays.asList("Смартфон", "Чехол"),
                "ул. Пушкина, д. 25", 800.50);

        Order order3 = new Order("ORD003",
                Arrays.asList("Наушники", "Зарядное устройство"),
                "пр. Мира, д. 15", 200.75);

        // Добавляем заказы в хэш-таблицу
        System.out.println("=== ДОБАВЛЕНИЕ ЗАКАЗОВ ===");
        orderTable.put(order1.getOrderNumber(), order1);
        orderTable.put(order2.getOrderNumber(), order2);
        orderTable.put(order3.getOrderNumber(), order3);

        System.out.println("Размер таблицы: " + orderTable.size());
        orderTable.display();

        // Поиск заказа
        System.out.println("\n=== ПОИСК ЗАКАЗА ===");
        Order foundOrder = orderTable.get("ORD002");
        if (foundOrder != null) {
            System.out.println("Найден заказ: " + foundOrder);
        } else {
            System.out.println("Заказ не найден");
        }

        // Обновление статуса заказа
        System.out.println("\n=== ОБНОВЛЕНИЕ СТАТУСА ЗАКАЗА ===");
        Order orderToUpdate = orderTable.get("ORD001");
        if (orderToUpdate != null) {
            orderToUpdate.setStatus("Доставляется");
            // Обновляем запись в таблице
            orderTable.put(orderToUpdate.getOrderNumber(), orderToUpdate);
            System.out.println("Обновленный заказ: " + orderTable.get("ORD001"));
        }

        // Удаление заказа
        System.out.println("\n=== УДАЛЕНИЕ ЗАКАЗА ===");
        boolean removed = orderTable.remove("ORD003");
        if (removed) {
            System.out.println("Заказ ORD003 удален");
        } else {
            System.out.println("Заказ ORD003 не найден");
        }

        System.out.println("Размер таблицы после удаления: " + orderTable.size());
        orderTable.display();

        // Проверка пустой таблицы
        System.out.println("\n=== ПРОВЕРКА ПУСТОЙ ТАБЛИЦЫ ===");
        System.out.println("Таблица пуста: " + orderTable.isEmpty());

        // Демонстрация коллизий
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КОЛЛИЗИЙ ===");
        HashTable<String, String> testTable = new HashTable<>(5);
        testTable.put("key1", "value1");
        testTable.put("key6", "value6"); // Возможная коллизия
        testTable.put("key11", "value11"); // Возможная коллизия
        testTable.display();
    }
}