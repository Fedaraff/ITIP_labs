package tasks_3;
import java.util.Scanner;

public class differenceMaxMin {

    public static int differenceMaxMin(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max - min;
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

        int difference = differenceMaxMin(numbers);
        System.out.println(difference);
        scanner.close();
    }
}