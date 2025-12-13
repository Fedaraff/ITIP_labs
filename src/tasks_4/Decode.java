package tasks_4;
import java.util.*;
import java.util.regex.*;

public class Decode {

    public static int[] decode(String text, String key) {
        int[] res = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            res[i] = text.charAt(i) ^ key.charAt(i % key.length());
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append(' ');
        }
        String input = sb.toString();

        Matcher m = Pattern.compile("[A-Za-z0-9]+").matcher(input);
        List<String> tokens = new ArrayList<>();
        while (m.find() && tokens.size() < 2) {
            tokens.add(m.group());
        }

        if (tokens.size() < 2) return;

        int[] ans = decode(tokens.get(0), tokens.get(1));
        System.out.print(Arrays.toString(ans));
    }
}
