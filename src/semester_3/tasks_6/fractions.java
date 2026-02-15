package semester_3.tasks_6;
import java.math.BigInteger;
import java.util.Scanner;

public class fractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        int dotIndex = input.indexOf('.');
        int openParenIndex = input.indexOf('(');
        int closeParenIndex = input.indexOf(')');

        String wholePart = input.substring(0, dotIndex);
        String nonRepeating = "";
        String repeating = "";

        if (openParenIndex != -1) {
            nonRepeating = input.substring(dotIndex + 1, openParenIndex);
            repeating = input.substring(openParenIndex + 1, closeParenIndex);
        } else {
            nonRepeating = input.substring(dotIndex + 1);
        }

        BigInteger intWhole = new BigInteger(wholePart);

        BigInteger numerator;
        BigInteger denominator;

        if (repeating.isEmpty()) {
            numerator = new BigInteger(wholePart + nonRepeating);
            denominator = BigInteger.TEN.pow(nonRepeating.length());
        } else {
            String n1 = wholePart + nonRepeating + repeating;
            String n2 = wholePart + nonRepeating;
            if (n2.isEmpty()) n2 = "0";

            BigInteger num1 = new BigInteger(n1);
            BigInteger num2 = new BigInteger(n2);

            numerator = num1.subtract(num2);
            int k1 = nonRepeating.length();
            int k2 = repeating.length();
            denominator = BigInteger.TEN.pow(k1 + k2).subtract(BigInteger.TEN.pow(k1));
        }

        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        System.out.println(numerator + "/" + denominator);
    }
}
