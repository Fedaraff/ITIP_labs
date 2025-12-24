package tasks_5;
import javax.swing.plaf.synth.SynthUI;
import java.util.*;

public class spread {

    public static double spread(int[] arr){
        if (arr.length == 0) return 0;
        int min = arr[0];
        int max = arr[0];
        double sum = 0;

        for (int x : arr){
            min = Math.min(min,x);
            max = Math.max(max,x);
            sum += x;
        }

        double average = sum / arr.length;

        if (average == 0){
            return 0;
        }
        return (max-min) / average;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();

        input = input.substring(1, input.length()-1);

        if (input.isEmpty()){
            System.out.println(0);
            return;
        }

        String[] parts = input.split(",");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++){
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        System.out.println(spread(arr));
    }
}
