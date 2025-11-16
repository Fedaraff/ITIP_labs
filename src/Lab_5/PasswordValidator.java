package Lab_5;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        String[] passwords = {
                "Password123",
                "weak",
                "nouppercase123",
                "NODIGITS",
                "ValidPass123"
        };

        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");

            for (String password : passwords) {
                Matcher matcher = pattern.matcher(password);
                if (matcher.matches()) {
                    System.out.println("Пароль '" + password + "' - КОРРЕКТНЫЙ");
                } else {
                    System.out.println("Пароль '" + password + "' - НЕКОРРЕКТНЫЙ");
                }
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}