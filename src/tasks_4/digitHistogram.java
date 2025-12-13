package tasks_4;
import java.util.Scanner;

public class digitHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String numberStr = input.replaceAll("[^0-9]", "");


        int[] histogram = digitHistogram(numberStr);

        System.out.print("[");
        for (int i = 0; i < histogram.length; i++) {
            System.out.print(histogram[i]);
            if (i < histogram.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");

        scanner.close();
    }

    public static int[] digitHistogram(String number) {
        int[] result = new int[10];

        for (int i = 0; i < number.length(); i++) {
            char digitChar = number.charAt(i);

            if (Character.isDigit(digitChar)) {
                int digit = digitChar - '0';
                result[digit]++;
            }
        }

        return result;
    }
}