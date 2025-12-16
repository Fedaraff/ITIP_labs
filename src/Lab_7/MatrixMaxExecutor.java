package Lab_7;

import java.util.concurrent.*;

public class MatrixMaxExecutor {
    public static void main(String[] args) throws Exception {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = (int) (Math.random() * 1000);
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Integer>[] futures = new Future[4];

        int rowsPerPart = 10 / 4;

        for (int i = 0; i < 4; i++) {
            final int startRow = i * rowsPerPart;
            final int endRow = (i == 3) ? 10 : startRow + rowsPerPart;

            futures[i] = executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int row = startRow; row < endRow; row++) {
                    for (int col = 0; col < 10; col++) {
                        if (matrix[row][col] > max) {
                            max = matrix[row][col];
                        }
                    }
                }
                return max;
            });
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            int partMax = future.get();
            if (partMax > globalMax) {
                globalMax = partMax;
            }
        }

        executor.shutdown();

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}