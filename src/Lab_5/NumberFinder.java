package Lab_5;
import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Для рецепта нужно 200 грамм муки и 2 яйца.";

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