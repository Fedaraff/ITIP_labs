package tasks_3;
import java.util.Scanner;

public class countVowels {
    public static int countVowels(String input) {
        int count = 0;
        String lowerCaseInput = input.toLowerCase();
        for (int i = 0; i < lowerCaseInput.length(); i++) {
            char currentChar = lowerCaseInput.charAt(i);
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = countVowels(input);
        System.out.println(result);
        scanner.close();
    }
}
