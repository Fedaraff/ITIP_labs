package Lab_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Счетчик объектов: " + ComputerPeripheral.getTotalObjects());

        // Создание объектов
        Keyboard keyboard = new Keyboard("Logitech", "USB", 3000, "Mechanical", true);
        Headphones headphones = new Headphones("Sony", "Wireless", 8000, "Over-ear", true);
        GraphicsTablet tablet = new GraphicsTablet("Wacom", "USB", 15000, 4096, true);

        System.out.println("\nСозданные устройства:");
        System.out.println("1. " + keyboard.getDeviceInfo());
        System.out.println("2. " + headphones.getDeviceInfo());
        System.out.println("3. " + tablet.getDeviceInfo());

        // Демонстрация полиморфизма (общий интерфейс - своя реализация)
        System.out.println("\nПОЛИМОРФИЗМ");
        ComputerPeripheral[] devices = {keyboard, headphones, tablet};

        for (ComputerPeripheral device : devices) {
            System.out.println(device.getDeviceInfo());
            device.performAction();
        }

        // Демонстрация инкапсуляции (доступ через отдельные методы)
        System.out.println("\n ИНКАПСУЛЯЦИЯ");
        System.out.println("Старая цена наушников: " + headphones);
        headphones.setPrice(9000);
        System.out.println("Новая цена наушников: " + headphones.getPrice());

        // Специфичное поведение
        System.out.println("\n СПЕЦИФИЧНОЕ ПОВЕДЕНИЕ");
        keyboard.type("Hello World!");
        headphones.playMusic("My Song");
        tablet.draw();

        // Счетчик объектов
        System.out.println("\n СЧЕТЧИК ОБЪЕКТОВ");
        System.out.println("Всего создано объектов: " + ComputerPeripheral.getTotalObjects());;

        // Ввод от пользователя
        simpleUserInput();
    }

    public static void simpleUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n СОЗДАНИЕ НОВОЙ КЛАВИАТУРЫ");

        System.out.print("Введите бренд: ");
        String brand = scanner.nextLine();

        System.out.print("Тип подключения (USB/Wireless): ");
        String connection = scanner.nextLine();

        System.out.print("Цена: ");
        double price = scanner.nextDouble();

        scanner.nextLine(); // очистка буфера

        System.out.print("Тип клавиатуры (Mechanical/Membrane): ");
        String type = scanner.nextLine();

        System.out.print("Подсветка (true/false): ");
        boolean backlight = scanner.nextBoolean();

        Keyboard userKeyboard = new Keyboard(brand, connection, price, type, backlight);

        System.out.println("\nСоздана клавиатура: " + userKeyboard.getDeviceInfo());
        System.out.println("Всего объектов: " + ComputerPeripheral.getTotalObjects());

        scanner.close();
    }
}