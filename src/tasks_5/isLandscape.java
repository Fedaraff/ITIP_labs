package tasks_5;
import java.util.Scanner;

public class isLandscape {

    public static boolean isLandscape(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int peakIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[peakIndex]) {
                peakIndex = i;
            }
        }

        if (peakIndex == 0 || peakIndex == arr.length - 1) {
            return false;
        }

        for (int i = 0; i < peakIndex; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }

        for (int i = peakIndex; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static int[] parseArray(String input) {
        input = input.trim();
        if (input.startsWith("[") && input.endsWith("]")) {
            input = input.substring(1, input.length() - 1).trim();
        }

        if (input.isEmpty()) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] result = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            String input = scanner.nextLine();

            int[] array = parseArray(input);

            boolean result = isLandscape(array);
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: все элементы должны быть целыми числами.");
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}