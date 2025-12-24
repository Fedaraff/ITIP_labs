package tasks_5;
import java.util.Scanner;

public class skipSevenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = skipSevenSum(n);
        System.out.println(result);
        scanner.close();
    }
    public static int skipSevenSum(int n){
        int sum = 0;

        for (int i = 1; i <= n; i++){
            if (!containsDigitSeven(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean containsDigitSeven(int number){
        int num = Math.abs(number);

        while (num > 0){
            int digit = num % 10;

            if (digit == 7){
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
