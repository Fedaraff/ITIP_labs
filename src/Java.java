import java.util.Scanner;

public class Java{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int result = average(num1, num2, num3);
        System.out.println(result);
        scanner.close();
    }

    public static int average(int num1, int num2, int num3){
        return (num1 + num2 + num3) / 3;
    }
}