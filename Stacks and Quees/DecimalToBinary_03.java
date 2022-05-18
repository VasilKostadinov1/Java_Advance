package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> digit = new ArrayDeque<>();

        int decimal = Integer.parseInt(input);
        if (decimal == 0) {
            System.out.println(0);
        }
        while (decimal > 0) {
            digit.push(decimal % 2);
            decimal = decimal / 2;
        }
        while (!digit.isEmpty()) {
            System.out.print(digit.pop());
        }
    }
}
