package Lab_4;

public class ArrayAverage {
    public static void main(String[] args) {
        // Тестовые данные
        String[][] testArrays = {
                {"1", "2", "3", "4", "5"},  // нормальный случай
                {"1", "2", "abc", "4", "5"}, // нечисловой элемент
                {"1", "2", "3"},              // короткий массив для демонстрации
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

        try {
            System.out.print("Обрабатываем массив: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");

                // Проверка на null
                if (arr[i] == null) {
                    throw new NullPointerException("Элемент массива равен null на позиции " + i);
                }

                // Парсинг элемента в число
                int num = Integer.parseInt(arr[i]);
                sum += num;
                validCount++;
            }
            System.out.println();

            // Проверка деления на ноль
            if (validCount == 0) {
                throw new ArithmeticException("Нет допустимых элементов для вычисления среднего");
            }

            double average = (double) sum / validCount;
            System.out.println("Сумма элементов: " + sum);
            System.out.println("Количество допустимых элементов: " + validCount);
            System.out.println("Среднее арифметическое: " + average);

        } catch (NumberFormatException e) {
            System.out.println("\nОшибка: элемент массива не является числом - " + e.getMessage());
            System.out.println("Вычисляем среднее по " + validCount + " допустимым элементам");
            if (validCount > 0) {
                double average = (double) sum / validCount;
                System.out.println("Сумма допустимых элементов: " + sum);
                System.out.println("Среднее арифметическое по допустимым элементам: " + average);
            }
        } catch (NullPointerException e) {
            System.out.println("\nОшибка: " + e.getMessage());
            System.out.println("Вычисляем среднее по " + validCount + " допустимым элементам");
            if (validCount > 0) {
                double average = (double) sum / validCount;
                System.out.println("Сумма допустимых элементов: " + sum);
                System.out.println("Среднее арифметическое по допустимым элементам: " + average);
            }
        } catch (ArithmeticException e) {
            System.out.println("\nОшибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nНеожиданная ошибка: " + e.getMessage());
        }
    }
}