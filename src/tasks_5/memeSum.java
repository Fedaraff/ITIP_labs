package tasks_5;
import java.util.*;

public class memeSum {

    public static String memeSum(int a, int b){
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);

        int maxLen = Math.max(s1.length(),s2.length());
        s1 = String.format("%" + maxLen + "s", s1).replace(' ','0');
        s2 = String.format("%" + maxLen + "s", s2).replace(' ','0');

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLen; i++){
            int digit1 = s1.charAt(i) - '0';
            int digit2 = s2.charAt(i) - '0';
            result.append(digit1 + digit2);
        }
        return result.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] parts = input.split(",");

        int a = Integer.parseInt(parts[0].trim());
        int b = Integer.parseInt(parts[1].trim());

        System.out.println(memeSum(a,b));
    }
}
