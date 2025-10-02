package tasks_1;

import java.util.Scanner;

public class Even {

    public static boolean toEven(int number) {
        if (number % 2 == 0) return true;
        return false;

    }


    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = scanner.nextInt();

        boolean result = toEven(inputNumber);

        System.out.println(result);

        scanner.close();
    }
}
