package tasks_4;
import java.util.*;

public class bruteForce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        List<String> result = new ArrayList<>();
        if (n <= k) {
            generate("", n, k, result);
        }

        System.out.println(format(result));
    }

    static void generate(String current, int n, int k, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!current.contains("" + i)) {
                generate(current + i, n, k, result);
            }
        }
    }

    static String format(List<String> list) {
        if (list.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append("\"").append(list.get(i)).append("\"");
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}