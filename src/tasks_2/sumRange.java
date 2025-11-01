package tasks_2;
import java.util.Scanner;
public class sumRange {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        int num_1 = Integer.parseInt(parts[0].trim());
        int num_2 = Integer.parseInt(parts[1].trim());
        int result = sumRange(num_1, num_2);
        System.out.println(result);
        scanner.close();
    }

    public static int sumRange(int num_1, int num_2){
        int sum = 0;
        for (int i = num_1; i <= num_2; i++){
            sum += i;
        }
        return sum;
    }
}
