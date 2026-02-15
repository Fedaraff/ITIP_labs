import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class mergeUniqueSorted {

    public static int[] mergeUniqueSorted(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>();

        for (int num : a) {
            set.add(num);
        }
        for (int num : b) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }

        return result;
    }

    public static int[] parseArray(String arrayStr) {
        arrayStr = arrayStr.trim();

        if (arrayStr.equals("[]")) {
            return new int[0];
        }

        if (arrayStr.startsWith("[") && arrayStr.endsWith("]")) {
            arrayStr = arrayStr.substring(1, arrayStr.length() - 1).trim();
        }

        if (arrayStr.isEmpty()) {
            return new int[0];
        }

        String[] elements = arrayStr.split(",");
        int[] array = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i].trim());
        }

        return array;
    }


    public static String formatArrayWithoutSpaces(int[] array) {
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        int commaIndex = input.indexOf("],");

        String firstArrayStr = input.substring(0, commaIndex + 1).trim();
        String secondArrayStr = input.substring(commaIndex + 1).trim();

        if (!secondArrayStr.startsWith("[")) {
            secondArrayStr = secondArrayStr.substring(secondArrayStr.indexOf("["));
        }
        if (secondArrayStr.endsWith(",")) {
            secondArrayStr = secondArrayStr.substring(0, secondArrayStr.length() - 1);
        }

        int[] firstArray = parseArray(firstArrayStr);
        int[] secondArray = parseArray(secondArrayStr);

        int[] result = mergeUniqueSorted(firstArray, secondArray);

        System.out.println(formatArrayWithoutSpaces(result));
        scanner.close();
    }
}