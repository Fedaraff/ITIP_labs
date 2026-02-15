package semester_3.tasks_6;
import java.util.Scanner;

public class pilish_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        int[] piDigits = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (int length : piDigits) {
            if (index >= input.length()) break;

            if (index + length <= input.length()) {
                result.append(input.substring(index, index + length));
            } else {
                String part = input.substring(index);
                char lastChar = part.charAt(part.length() - 1);
                while (part.length() < length) {
                    part += lastChar;
                }
                result.append(part);
            }

            index += length;
            if (index < input.length()) {
                result.append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }
}
