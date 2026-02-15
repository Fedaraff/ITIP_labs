package semester_3.tasks_6;

import java.util.*;

public class twoProduct {

    public static int[] twoProduct(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            if (n % current == 0) {
                int needed = n / current;

                if (map.containsKey(needed)) {
                    int firstIndex = map.get(needed);
                    if (firstIndex < i) {
                        return new int[]{arr[firstIndex], current};
                    } else {
                        return new int[]{current, arr[firstIndex]};
                    }
                }
            }
            map.put(current, i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();


            int lastBracket = input.lastIndexOf(']');

            String arrayPart = input.substring(0, lastBracket + 1);
            String nPart = input.substring(lastBracket + 1).trim();

            arrayPart = arrayPart.substring(1, arrayPart.length() - 1);
            String[] numStrings = arrayPart.split(",\\s*");
            int[] arr = new int[numStrings.length];

            for (int i = 0; i < numStrings.length; i++) {
                arr[i] = Integer.parseInt(numStrings[i].trim());
            }

            int n = Integer.parseInt(nPart);

            int[] result = twoProduct(arr, n);

            if (result.length == 0) {
                System.out.println("[]");
            } else {
                System.out.println("[" + result[0] + ", " + result[1] + "]");
            }

        }

        scanner.close();
    }
}
