package tasks_5;
import java.util.Scanner;

public class findShift {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().replace(" ", "").split(",");

        if (parts.length != 2){
            System.out.println(-1);
            return;
        }

        String s1 = parts[0], s2 = parts[1];

        if (s1.length() != s2.length()) {
            System.out.println(-1);
            return;
        }

        int shift = (s2.charAt(0) - s1.charAt(0) + 26) % 26;

        for (int i = 0; i < s1.length(); i++) {
            char expected = (char) ('a' + (s1.charAt(i) - 'a' + shift) % 26);
            if (s2.charAt(i) != expected) {
                System.out.println(-1);
                return;
            }
        }
    System.out.println(shift);
        scanner.close();
    }
}
