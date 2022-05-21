package StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .forEach(x -> stack.push(Integer.parseInt(x)));

        for (Integer number : stack) {
            System.out.printf("%d ", stack.pop());
        }
    }
}
