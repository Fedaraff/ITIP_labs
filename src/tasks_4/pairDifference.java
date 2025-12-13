package tasks_4;
import java.util.*;

public class pairDifference {

    public static int countPairsWithDifference(int[] arr, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        if (k == 0) {
            for (int freq : frequency.values()) {
                count += freq * (freq - 1) / 2;
            }
        } else {
            for (int num : frequency.keySet()) {
                if (frequency.containsKey(num + k)) {
                    count += frequency.get(num) * frequency.get(num + k);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        int commaIndex = input.lastIndexOf(',');

        String arrayPart = input.substring(0, commaIndex).trim();
        String kPart = input.substring(commaIndex + 1).trim();

        int k = Integer.parseInt(kPart);

        if (arrayPart.startsWith("[") && arrayPart.endsWith("]")) {
            arrayPart = arrayPart.substring(1, arrayPart.length() - 1).trim();
        }

        String[] numberStrings = arrayPart.split("[,\\s]+");
        List<Integer> numbers = new ArrayList<>();

        for (String numStr : numberStrings) {
            if (!numStr.trim().isEmpty()) {
                numbers.add(Integer.parseInt(numStr.trim()));
            }
        }

        int[] arr = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            arr[i] = numbers.get(i);
        }

        int result = countPairsWithDifference(arr, k);

        System.out.println(result);
        scanner.close();
    }
}