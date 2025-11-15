package tasks_3;
import java.util.Arrays;
import java.util.Scanner;

public class isAnagram {

    public static boolean isAnagram(String str1, String str2) {
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] strings = input.split(",");
        String str1 = strings[0].trim();
        String str2 = strings[1].trim();

        boolean result = isAnagram(str1, str2);

        System.out.println(result);
        scanner.close();
    }
}