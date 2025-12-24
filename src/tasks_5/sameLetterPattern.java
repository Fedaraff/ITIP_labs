package tasks_5;
import java.util.*;

public class sameLetterPattern {

    public static boolean sameLetterPattern(String s1, String s2){
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i= 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (map1.containsKey(c1)){
                if (map1.get(c1) != c2) return false;
            } else {
                map1.put(c1,c2);
            }

            if (map2.containsKey(c2)){
                if (map2.get(c2) != c1) return false;
            } else {
                map2.put(c2,c1);
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] parts = input.split(",");

        String s1 = parts[0].trim();
        String s2 = parts[1].trim();

        System.out.println(sameLetterPattern(s1,s2));
    }
}
