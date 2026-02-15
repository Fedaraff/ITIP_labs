package semester_3.tasks_6;
import java.util.*;

public class isExact {
    public static int[] isExact(int num) {
        return checkFactorial(num, 1, 1);
    }

    private static int[] checkFactorial(int target, int current, int n) {
        if (current == target) {
            return new int[]{target, n};
        }
        if (current > target) {
            return new int[]{};
        }
        return checkFactorial(target, current * (n + 1), n + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        int[] result = isExact(num);
        System.out.println(Arrays.toString(result));
    }
}
