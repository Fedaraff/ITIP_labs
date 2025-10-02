package tasks_1;

import java.util.Scanner;

public class toFahrenheit {

    // Метод для перевода температуры из Цельсия в Фаренгейты
    public static double toFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    // Главный метод программы
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод температуры в Цельсиях
        double celsius = scanner.nextDouble();

        // Перевод в Фаренгейты
        double fahrenheit = toFahrenheit(celsius);

        // Вывод результата
        System.out.println((int)fahrenheit);

        scanner.close();
    }
}
