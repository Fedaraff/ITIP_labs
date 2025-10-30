package Lab_4_1;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream sourceFile = null;
        FileOutputStream targetFile = null;

        try {
            sourceFile = new FileInputStream("Lab_4_1/source.txt");
            targetFile = new FileOutputStream("Lab_4_1/target.txt");

            int byteData;
            while ((byteData = sourceFile.read()) != -1) {
                targetFile.write(byteData);
            }
            System.out.println("Файл успешно скопирован.");

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            try {
                if (sourceFile != null) {
                    sourceFile.close();
                }
                if (targetFile != null) {
                    targetFile.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файлов: " + e.getMessage());
            }
        }
    }
}
