package Lab_4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[][] testArrays = {
                {"1", "2", "3", "4", "5"},
                {"1", "2", "abc", "4", "5"},
                {"1", "2", "3"},
                {"1", null, "4", "5"},
                {}
        };

        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("Тест " + (i + 1) + ":");
            calculateAverage(testArrays[i]);
            System.out.println();
        }
    }

    public static void calculateAverage(String[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Ошибка: массив пуст или равен null");
            return;
        }

        int sum = 0;
        int validCount = 0;

        System.out.print("Обрабатываем массив: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Обрабатываем каждый элемент с обработкой ошибок
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] == null) {
                    throw new NullPointerException("Элемент массива равен null на позиции " + i);
                }

                int num = Integer.parseInt(arr[i]);
                sum += num;
                validCount++;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: элемент '" + arr[i] + "' на позиции " + i + " не является числом");
            } catch (NullPointerException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        try {
            if (validCount == 0) {
                throw new ArithmeticException("Нет допустимых элементов для вычисления среднего");
            }

            double average = (double) sum / validCount;
            System.out.println("Сумма допустимых элементов: " + sum);
            System.out.println("Количество допустимых элементов: " + validCount);
            System.out.println("Среднее арифметическое: " + average);

        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}