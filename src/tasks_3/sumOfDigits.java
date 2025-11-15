package tasks_3;
import java.util.Scanner;

public class sumOfDigits {

    public static int sumOfDigits(int number) {
        int num = number;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int result = sumOfDigits(number);
        System.out.println(result);
        scanner.close();
    }
}