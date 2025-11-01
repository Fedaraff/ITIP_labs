import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class hasDuplicates {

    public static boolean hasDuplicates(int[] array) {
        if (array == null || array.length <= 1) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();

        for (int num : array) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        String[] stringNumbers = input.split(",");
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i].trim());
        }
        boolean result = hasDuplicates(numbers);
        System.out.println(result);
        scanner.close();
    }
}