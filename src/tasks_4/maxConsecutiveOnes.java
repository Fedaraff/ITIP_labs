package tasks_4;
import java.util.Scanner;

public class maxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();

        String numbersStr = input.substring(1, input.length() - 1).replace(" ", "");
        String[] strArray = numbersStr.split(",");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            int num = Integer.parseInt(strArray[i]);

            array[i] = num;
        }
        int maxCount = maxConsecutiveOnes(array);
        System.out.println(maxCount);
    }

    public static int maxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }
}