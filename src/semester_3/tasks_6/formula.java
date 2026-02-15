package semester_3.tasks_6;

import java.util.Scanner;
import java.util.*;

public class formula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        sc.close();

        String[] parts = expr.split("=");
        List<Double> values = new ArrayList<>();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();
            if (part.isEmpty()) continue;

            String[] tokens = part.split(" ");
            List<String> tokenList = new ArrayList<>();

            for (String token : tokens) {
                if (!token.trim().isEmpty()) {
                    tokenList.add(token.trim());
                }
            }

            List<String> postfix = toPostfix(tokenList);
            double value = evaluatePostfix(postfix);
            values.add(value);
        }

        boolean valid = true;
        if (values.size() > 1) {
            double first = values.get(0);
            for (int i = 1; i < values.size(); i++) {
                if (Math.abs(values.get(i) - first) > 0.000001) {
                    valid = false;
                    break;
                }
            }
        }

        System.out.println(valid);
    }

    private static List<String> toPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    private static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }

        return stack.pop();
    }

    private static boolean isNumber(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }
}
