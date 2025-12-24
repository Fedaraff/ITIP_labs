package tasks_5;
import java.util.Scanner;

public class turns {

    public static int turns(int number){
        String digits = Integer.toString(number);

        if (digits.length() < 3) {
            return 0;
        }

        int turns = 0;
        int direction = 0;

        for (int i = 1; i < digits.length(); i++){
            int prevDigit = digits.charAt(i-1) - '0';
            int currDigit = digits.charAt(i) - '0';

            int currentDirection = Integer.compare(currDigit, prevDigit);

            if (currentDirection == 0){
                continue;
            }

            if (direction == 0){
                direction = currentDirection;
            } else if (direction != currentDirection) {
                turns++;
                direction = currentDirection;
            }
        }
        return turns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int result = turns(number);
        System.out.println(result);
    }
}
