import java.util.Scanner;
import java.util.Arrays;

public class diagonalSum {

    public static int diagonalSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }


    public static int[][] parseMatrix(String input) {
        input = input.trim();
        if (input.startsWith("[[")) {
            input = input.substring(1, input.length() - 1);
        }

        String[] rows = input.split("\\],\\[");

        int n = rows.length;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = rows[i].replace("[", "").replace("]", "").trim();
            String[] elements = row.split(",");

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(elements[j].trim());
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int[][] matrix = parseMatrix(input);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i].length != n) {
                System.out.println("Ошибка: матрица должна быть квадратной");
                return;
            }
        }
        int result = diagonalSum(matrix);
        System.out.println(result);
        scanner.close();
    }
}