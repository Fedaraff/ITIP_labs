package Lab_5;
import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Java is a popular programming language used for various applications";
        char startLetter = 'p'; // искомая буква

        try {
            // Регулярное выражение для поиска слов, начинающихся с заданной буквы
            // \\b - граница слова
            // [" + startLetter + "] - искомая буква (учитывается регистр)
            // [a-zA-Z]* - любые буквы после искомой
            // \\b - граница слова
            Pattern pattern = Pattern.compile("\\b[" + startLetter + "][a-zA-Z]*\\b");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Текст: " + text);
            System.out.println("Слова, начинающиеся с буквы '" + startLetter + "':");

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