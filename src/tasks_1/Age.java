package tasks_1;

import java.util.Scanner;

public class Age {
    public static String checkAge(int Age) {
        if (Age >= 18) return "совершеннолетний";
        return "несовершеннолетний";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputDays = scanner.nextInt();
        String result = checkAge(inputDays);
        System.out.println(result);
        scanner.close();
    }

}
