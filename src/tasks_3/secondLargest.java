package tasks_3;
import java.util.Scanner;

public class secondLargest {

    public static int secondLargest(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num < firstMax) {
                secondMax = num;
            }
        }
        return secondMax;
    }

    public static int[] parseArray(String input) {

        String cleaned = input.replace("[", "").replace("]", "").replace(" ", "");

        String[] stringNumbers = cleaned.split(",");
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbers = parseArray(input);
        int result = secondLargest(numbers);
        System.out.println(result);
        scanner.close();
    }
}