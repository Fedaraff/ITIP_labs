package Lab_8;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            DataManager manager = new DataManager();

            manager.registerDataProcessor(new FilterProcessor());
            manager.registerDataProcessor(new TransformProcessor());
            manager.registerDataProcessor(new AggregateProcessor());

            manager.loadData("src/Lab_8/input.txt");
            System.out.println("Данные загружены");

            manager.processData();
            System.out.println("Данные обработаны");

            manager.saveData("src/Lab_8/output.txt");
            System.out.println("Результаты сохранены в output.txt");

            List<String> results = Files.readAllLines(Paths.get("src/Lab_8/output.txt"));
            System.out.println("\nРезультаты обработки:");
            results.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


