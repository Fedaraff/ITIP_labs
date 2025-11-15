package tasks_3;

import java.util.Arrays;
import java.util.Scanner;

public class filterEven {

    public static int[] filterEven(int[] numbers) {
        int evenCount = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            }
        }

        int[] result = new int[evenCount];

        int index = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                result[index] = number;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String cleanedInput = input.replace("[", "").replace("]", "").replace(" ", "");

        String[] numberStrings = cleanedInput.split(",");

        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }
        int[] evenNumbers = filterEven(numbers);

        System.out.println(Arrays.toString(evenNumbers));
        scanner.close();
    }
}
