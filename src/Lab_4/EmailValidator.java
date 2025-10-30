package Lab_4;

import java.io.*;

class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException(String message) {
        super(message);
    }
}

public class EmailValidator {
    public static void validateEmail(String email) throws CustomEmailFormatException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!email.matches(emailRegex)) {
            throw new CustomEmailFormatException("Неверный формат email: " + email);
        }
    }

    public static void main(String[] args) {
        String[] emails = {"test@example.com", "invalid-email", "another@test.ru"};

        for (String email : emails) {
            try {
                validateEmail(email);
                System.out.println("Email корректен: " + email);
            } catch (CustomEmailFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}