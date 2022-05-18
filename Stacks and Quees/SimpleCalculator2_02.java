package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        numbers.push(Integer.parseInt(input[0]));

        for (int i = 1; i < input.length; i += 2) {
            if (!numbers.isEmpty()) {
                numbers.push(input[i].equals("+")
                        ? numbers.peek() + Integer.parseInt(input[i + 1])
                        : numbers.peek() - Integer.parseInt(input[i + 1]));
            }
        }
        System.out.println(numbers.peek());
    }
}
