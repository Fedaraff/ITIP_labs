package tasks_1;

import java.util.Scanner;


public class Palindrome_task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        boolean result = isPalindrome(word);
        System.out.println(result);
        scanner.close();

    }

    public static String reverseString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}