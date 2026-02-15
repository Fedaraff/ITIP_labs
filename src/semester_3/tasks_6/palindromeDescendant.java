package semester_3.tasks_6;
import java.util.Scanner;

public class palindromeDescendant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        String current = Integer.toString(num);

        while (current.length() > 1) {
            if (isPalindrome(current)) {
                System.out.println("true");
                return;
            }

            if (current.length() % 2 != 0) {
                System.out.println("false");
                return;
            }

            StringBuilder next = new StringBuilder();
            for (int i = 0; i < current.length(); i += 2) {
                int a = current.charAt(i) - '0';
                int b = current.charAt(i + 1) - '0';
                next.append(a + b);
            }
            current = next.toString();
        }

        System.out.println("false");
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
