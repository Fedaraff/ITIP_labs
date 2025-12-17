package Lab_7;

public class MatrixMaxThreads {

    private static int[][] matrix;
    private static int[] maxPerRow;

    public static void main(String[] args) throws InterruptedException {

        matrix = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = (int) (Math.random() * 1000);
            }
        }

        maxPerRow = new int[10];
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {

            final int row = i;

            threads[i] = new Thread(() -> {

                int max = matrix[row][0];

                for (int j = 1; j < 10; j++) {
                    if (matrix[row][j] > max) {
                        max = matrix[row][j];
                    }
                }

                maxPerRow[row] = max;
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int globalMax = maxPerRow[0];

        for (int i = 1; i < 10; i++) {
            if (maxPerRow[i] > globalMax) {
                globalMax = maxPerRow[i];
            }
        }

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}