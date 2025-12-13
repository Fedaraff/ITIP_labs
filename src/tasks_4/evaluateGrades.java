package tasks_4;
import java.util.*;

public class evaluateGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        input = input.replace("[", "").replace("]", "").replace(" ", "");

        String[] gradesStr = input.split(",");
        int[] grades = new int[gradesStr.length];
        for (int i = 0; i < gradesStr.length; i++) {
            grades[i] = Integer.parseInt(gradesStr[i]);
        }
        Map<String, Integer> result = evaluateGrades(grades);

        System.out.println(formatResult(result));

        scanner.close();
    }

    public static Map<String, Integer> evaluateGrades(int[] grades) {
        Map<String, Integer> counts = new LinkedHashMap<>();

        counts.put("A", 0);
        counts.put("B", 0);
        counts.put("C", 0);
        counts.put("D", 0);
        counts.put("F", 0);

        for (int grade : grades) {
            if (grade >= 90 && grade <= 100) {
                counts.put("A", counts.get("A") + 1);
            } else if (grade >= 80 && grade <= 89) {
                counts.put("B", counts.get("B") + 1);
            } else if (grade >= 70 && grade <= 79) {
                counts.put("C", counts.get("C") + 1);
            } else if (grade >= 60 && grade <= 69) {
                counts.put("D", counts.get("D") + 1);
            } else if (grade >= 0 && grade <= 59) {
                counts.put("F", counts.get("F") + 1);
            }
        }

        return counts;
    }

    private static String formatResult(Map<String, Integer> counts) {
        StringBuilder sb = new StringBuilder("{");
        List<String> nonZero = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 0) {
                nonZero.add(entry.getKey() + ": " + entry.getValue());
            }
        }

        for (int i = 0; i < nonZero.size(); i++) {
            sb.append(nonZero.get(i));
            if (i < nonZero.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}