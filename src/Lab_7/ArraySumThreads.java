package Lab_7;

public class ArraySumThreads {
    private static int[] array;
    private static int sum1 = 0;
    private static int sum2 = 0;

    public static void main(String[] args) throws InterruptedException {
        array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < array.length / 2; i++) {
                sum1 += array[i];
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = array.length / 2; i < array.length; i++) {
                sum2 += array[i];
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int totalSum = sum1 + sum2;
        System.out.println("Сумма элементов массива: " + totalSum);
        System.out.println("Ожидаемая сумма: " + (1000 * 1001 / 2));
    }
}