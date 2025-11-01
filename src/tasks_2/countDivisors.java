package tasks_2;
import java.util.Scanner;

public class countDivisors {

    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int divisorsCount = countDivisors(number);
        System.out.println(divisorsCount);
        scanner.close();
    }
}