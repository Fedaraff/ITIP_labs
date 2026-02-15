package semester_3.tasks_6;
import java.util.*;

public class isValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> countFreq = new HashMap<>();
        for (int count : freq.values()) {
            countFreq.put(count, countFreq.getOrDefault(count, 0) + 1);
        }

        if (countFreq.size() == 1) {
            System.out.println("YES");
        } else if (countFreq.size() == 2) {
            List<Integer> counts = new ArrayList<>(countFreq.keySet());
            int count1 = counts.get(0);
            int count2 = counts.get(1);
            int freq1 = countFreq.get(count1);
            int freq2 = countFreq.get(count2);

            if ((freq1 == 1 && (count1 == 1 || count1 - 1 == count2)) ||
                    (freq2 == 1 && (count2 == 1 || count2 - 1 == count1))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }
}
