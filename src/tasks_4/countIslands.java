package tasks_4;
import java.util.Scanner;

public class countIslands {

    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    islandCount++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return islandCount;
    }

    private static void dfs(int[][] grid, int i, int j, int rows, int cols) {

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = -1;
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
    }


    public static int[][] parseInput(String input) {
        input = input.trim();
        input = input.substring(2, input.length() - 2);


        String[] rows = input.split("\\],\\[");

        int numRows = rows.length;
        String[] firstRow = rows[0].split(",");
        int numCols = firstRow.length;

        int[][] grid = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] values = rows[i].split(",");
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = Integer.parseInt(values[j].trim());
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[][] grid = parseInput(input);

        int result = countIslands(grid);

        System.out.println( result);

        scanner.close();
    }
}