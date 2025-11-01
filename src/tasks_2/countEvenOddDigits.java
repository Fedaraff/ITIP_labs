import java.util.Scanner;

public class countEvenOddDigits {

    public static int[] countEvenOddDigits(int n) {
        long number = Math.abs((long) n);

        if (number == 0) {
            return new int[]{1, 0};
        }

        int evenCount = 0;
        int oddCount = 0;

        while (number > 0) {
            int digit = (int)(number % 10);
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            number /= 10;
        }
        return new int[]{evenCount, oddCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] result = countEvenOddDigits(n);
        System.out.println(result[0] + ", " + result[1]);
        scanner.close();
    }
}