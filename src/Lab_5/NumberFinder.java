package Lab_5;
import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99, there are 25 items, and temperature is -5.5 degrees";

        try {
            Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Найденные числа в тексте:");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}