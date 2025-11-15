package tasks_3;
import java.util.Scanner;

public class countWords {

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String trimmedText = text.trim();
        if (trimmedText.isEmpty()) {
            return 0;
        }

        String[] words = trimmedText.split("\\s+");

        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int wordCount = countWords(input);
        System.out.println(wordCount);
        scanner.close();
    }
}