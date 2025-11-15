package tasks_3;
import java.util.Scanner;

public class isTriangle {

    public static boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String cleanedInput = input.replace(" ", "");
        String[] sides = cleanedInput.split(",");

        int a = Integer.parseInt(sides[0]);
        int b = Integer.parseInt(sides[1]);
        int c = Integer.parseInt(sides[2]);

        boolean result = isTriangle(a, b, c);

        System.out.println(result);
        scanner.close();
    }
}