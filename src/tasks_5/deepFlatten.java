package tasks_5;
import java.util.*;

public class deepFlatten {
    public static void deepFlatten(Object[] arr, List<Object> result) {
        for (Object elem : arr){
            if (elem instanceof Object[]) {
                deepFlatten((Object[]) elem, result);
            } else {
                result.add(elem);
            }
        }
    }

    public static List<Object> deepFlatten(Object[] arr) {
        List<Object> result = new ArrayList<>();
        deepFlatten(arr, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Object[] arr = parseInput(input);
        List<Object> flat = deepFlatten(arr);
        System.out.println(flat);
    }

    public static Object[] parseInput(String s){
        s = s.replaceAll("\\s+", "");
        return parseArray(new StringTokenizer(s, "[], ", true));
    }

    public static Object[] parseArray(StringTokenizer tokenizer){
        List<Object> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            if (token.equals("[")) {
                list.add(parseArray(tokenizer));
            } else if (token.equals("]")) {
                break;
            } else if (token.equals(",")) {
                continue;
            } else {
                list.add(Integer.parseInt(token));
            }
        }
        return list.toArray();
    }
}
