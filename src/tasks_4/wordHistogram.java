package tasks_4;
import java.util.*;

public class wordHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> result = new LinkedHashMap<>();

        String[] words = input.toLowerCase().split("[^a-zа-яё0-9']+");

        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.replaceAll("^'+|'+$", "");
                if (!word.isEmpty()) {
                    result.put(word, result.getOrDefault(word, 0) + 1);
                }
            }
        }

        System.out.println(formatResult(result));
    }

    private static String formatResult(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder("{");
        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (i > 0) sb.append(", ");
            sb.append(entry.getKey()).append(": ").append(entry.getValue());
            i++;
        }
        sb.append("}");
        return sb.toString();
    }
}