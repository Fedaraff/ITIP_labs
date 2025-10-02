package tasks_1;

import java.util.Scanner;

public class Rectagle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        double area = rectangleArea(length, width);

        // Вывод результата
        System.out.println(area);

        scanner.close();
    }

    public static double rectangleArea(double length, double width) {
        return length * width;
    }
}
