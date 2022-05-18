package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> indexesOfOpeningBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                indexesOfOpeningBrackets.push(i);
            } else if (input.charAt(i) == ')') {
                int start = indexesOfOpeningBrackets.pop();
                System.out.println(input.substring(start, i + 1));
            }
        }
    }
}
