package tasks_5;
import java.util.*;

public class uniqueOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = uniqueOrder(input);
        System.out.println(result);
        scanner.close();
    }

    public static String uniqueOrder(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        Set<Character> seen = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            seen.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (Character c : seen) {
            result.append(c);
        }
        return result.toString();
    }
}
