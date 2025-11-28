package Lab_6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/Lab_6/text.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-za-я]", "");
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        scanner.close();

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
        sortedList.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Топ-10 самых частых слов:");
        for (int i = 0; i < Math.min(10, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }
    }
}