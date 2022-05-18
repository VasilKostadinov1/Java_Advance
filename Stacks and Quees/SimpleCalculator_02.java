package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> digits = new ArrayDeque<>(Arrays.asList(input));
        while (digits.size() > 1) {

            int leftDigit = Integer.parseInt(digits.pop());
            String operator = digits.pop();
            int rightDigit = Integer.parseInt(digits.pop());

            int result = 0;

            if (operator.equals("-")) {
                result = leftDigit - rightDigit;
            } else {
                result = leftDigit + rightDigit;
            }
            digits.push(String.valueOf(result));
        }
        String finalResult = digits.peek();
        System.out.println(finalResult);
    }
}
