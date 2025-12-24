package tasks_5;
import java.util.*;

public class maxEvenSubarray {

    public static int maxEvenSubarray(int[] arr){
        int n = arr.length;
        int maxSum = 0;

        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];

                if (i == 0 && j == n - 1) continue;

                if (sum % 2 == 0){
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");

        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++){
            arr[i] = Integer.parseInt(parts[i].trim());
        }

        System.out.println(maxEvenSubarray(arr));
    }

}
