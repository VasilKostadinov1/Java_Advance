package StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean areBalanced = false;

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                stack.push(currentBracket);

            } else if (currentBracket == ')' || currentBracket == ']' || currentBracket == '}') {

                if (stack.isEmpty()) {     // 75/100 without this check  !!!!
                    areBalanced = false;
                    break;
                } else {
                    char lastOpeningBracket = stack.pop();  // we can pop only from stack that is not empty !!!!

                    if (lastOpeningBracket == '(' && currentBracket == ')') {
                        areBalanced = true;

                    } else if (lastOpeningBracket == '[' && currentBracket == ']') {
                        areBalanced = true;

                    } else if (lastOpeningBracket == '{' && currentBracket == '}') {
                        areBalanced = true;

                    } else {
                        areBalanced = false;
                        break;
                    }
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
