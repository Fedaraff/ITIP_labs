
package tasks_4;
import java.util.Scanner;

public class nonRepeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(nonRepeat(input));
        scanner.close();
    }

    public static String nonRepeat(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String lowerS = s.toLowerCase();
        char firstCharLower = lowerS.charAt(0);
        int totalCount = 0;

        for (int i = 0; i < lowerS.length(); i++) {
            if (lowerS.charAt(i) == firstCharLower) {
                totalCount++;
            }
        }

        if (totalCount > 3) {
            StringBuilder newString = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (Character.toLowerCase(s.charAt(i)) != firstCharLower) {
                    newString.append(s.charAt(i));
                }
            }
            return nonRepeat(newString.toString());
        }
        else {
            return s.charAt(0) + nonRepeat(s.substring(1));
        }
    }
}