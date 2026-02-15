package semester_3.tasks_6;
import java.util.Scanner;

public class rotateRing {

    public static String rotateRing(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int n = s.length();
        k = k % n;

        if (k < 0) {
            k = n + k;
        }
        if (k == 0) {
            return s;
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            int newPos = (i + k) % n;
            result[i] = s.charAt(newPos);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim();
            int lastSpace = inputLine.lastIndexOf(' ');
            String s = inputLine.substring(0, lastSpace);
            String kStr = inputLine.substring(lastSpace + 1);
            int k = Integer.parseInt(kStr);
            System.out.println(rotateRing(s, k));
        }
        scanner.close();
}
}
