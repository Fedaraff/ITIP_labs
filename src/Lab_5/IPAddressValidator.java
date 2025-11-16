package Lab_5;
import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String[] ipAddresses = {
                "192.168.1.1",
                "255.255.255.255",
                "0.0.0.0",
                "256.1.1.1",
                "192.168.1",
                "192.168.1.1.1",
                "192.168.1.abc"
        };

        try {
            Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

            for (String ip : ipAddresses) {
                Matcher matcher = pattern.matcher(ip);
                if (matcher.matches()) {
                    System.out.println("IP-адрес '" + ip + "' - КОРРЕКТНЫЙ");
                } else {
                    System.out.println("IP-адрес '" + ip + "' - НЕКОРРЕКТНЫЙ");
                }
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}