package semester_3.tasks_6;

import java.util.*;

public class hiddenPalindrome {
    public static String hiddenPalindrome(String input) {
        String lettersOnly = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (lettersOnly.isEmpty()) {
            return "none";
        }

        int maxLength = 0;
        int bestStart = Integer.MAX_VALUE;
        String result = "none";

        for (int i = 0; i < lettersOnly.length(); i++) {
            for (int j = lettersOnly.length(); j > i; j--) {
                String substring = lettersOnly.substring(i, j);

                if (substring.length() < maxLength) {
                    continue;
                }

                if (canBePalindrome(substring)) {
                    if (substring.length() > maxLength) {
                        maxLength = substring.length();
                        bestStart = i;
                        result = substring;
                    }
                    else if (substring.length() == maxLength && i < bestStart) {
                        bestStart = i;
                        result = substring;
                    }

                }
            }
        }
        return result;
    }

    private static boolean canBePalindrome(String str) {
        int[] charCount = new int[26];
        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }

        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(hiddenPalindrome(input));
        }
        scanner.close();
    }
}