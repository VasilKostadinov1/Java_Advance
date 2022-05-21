package StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] n = scanner.nextLine().split(" ");

        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        //Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(numberStack::push);
        for (String value : n) {
            int current = Integer.parseInt(value);
            numberStack.push(current);
        }
        while (!numberStack.isEmpty()) {
            System.out.print(numberStack.pop() + " ");
        }
//        for (Integer number : numberStack) {
//            System.out.print(number + " ");
//        }
    }
}
