import java.util.Scanner;
import java.util.Arrays;

public class rotateRight {

    // Метод для циклического сдвига массива вправо на k позиций
    public static int[] rotateRight(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int effectiveK = k % arr.length;

        if (effectiveK == 0) {
            return arr.clone();
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int newPosition = (i + effectiveK) % arr.length;
            result[newPosition] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();

        int commaIndex = input.lastIndexOf(",");
        if (commaIndex == -1) {
            System.out.println("Ошибка: неправильный формат ввода");
            return;
        }

        String arrayPart = input.substring(0, commaIndex).trim();
        if (arrayPart.startsWith("[") && arrayPart.endsWith("]")) {
            arrayPart = arrayPart.substring(1, arrayPart.length() - 1).trim();
        }

        String kPart = input.substring(commaIndex + 1).trim();
        int k = Integer.parseInt(kPart);

        int[] array;
        if (arrayPart.isEmpty()) {
            array = new int[0];
        } else {
            String[] stringNumbers = arrayPart.split(",");
            array = new int[stringNumbers.length];
            for (int i = 0; i < stringNumbers.length; i++) {
                array[i] = Integer.parseInt(stringNumbers[i].trim());
            }
        }

        int[] rotatedArray = rotateRight(array, k);
        System.out.println(Arrays.toString(rotatedArray));
        scanner.close();
    }
}