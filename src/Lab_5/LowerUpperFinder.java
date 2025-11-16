package Lab_5;
import java.util.regex.*;

public class LowerUpperFinder {
    public static void main(String[] args) {
        String text = "helloWorld thisIsTest javaProgramming isFun";

        try {
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Исходный текст: " + text);
            System.out.println("Найденные переходы строчная-заглавная:");

            while (matcher.find()) {
                String found = matcher.group();
                System.out.println("!" + found + "! - позиция " + matcher.start());
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}