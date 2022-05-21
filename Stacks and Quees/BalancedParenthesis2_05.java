package StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // 87/100

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        boolean areBalanced = false;

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                stack.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == ']' || currentBracket == '}') {
                queue.offer(currentBracket);
            }
        }
        if (stack.size() != queue.size()) {
            System.out.println("NO");
        } else {
            while (!stack.isEmpty() && !queue.isEmpty()) {
                char lastOpen = stack.pop();
                char firstClosed = queue.poll();
                if (lastOpen == '(' && firstClosed == ')') {
                    areBalanced = true;

                } else if (lastOpen == '[' && firstClosed == ']') {
                    areBalanced = true;

                } else if (lastOpen == '{' && firstClosed == '}') {
                    areBalanced = true;

                } else {
                    areBalanced = false;
                    break;
                }
            }
            System.out.println(areBalanced ? "YES" : "NO");

//            if (areBalanced) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
        }


    }
}
