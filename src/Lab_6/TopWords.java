package Lab_6;

import java.util.*;
import java.nio.file.*;

public class TopWords {
    public static void main(String[] args) throws Exception {
        String text = Files.readString(Paths.get("src/Lab_6/text.txt"));
        Map<String, Integer> counter = new HashMap<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-za-я]", "");
            if (!word.isEmpty()) {
                counter.put(word, counter.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(counter.entrySet());
        sorted.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Топ-10 самых частых слов:");
        int limit = Math.min(10, sorted.size());
        for (int i = 0; i < limit; i++) {
            String word = sorted.get(i).getKey();
            int count = sorted.get(i).getValue();
            System.out.println((i + 1) + ". " + word + " - " + count);
        }
    }
}