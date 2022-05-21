package StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();
        int operations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < operations; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(tokens[0]);

            switch (command) {
                case 1:
                    stack.push(stringBuilder.toString());    // !!! keeps the current state/situation
                    String string = tokens[1];
                    stringBuilder.append(string);
                    break;
                case 2:
                    stack.push(stringBuilder.toString());
                    int count = Integer.parseInt(tokens[1]);
                    stringBuilder.delete(stringBuilder.length() - count, stringBuilder.length());
                    break;
                case 3:
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(stringBuilder.charAt(index - 1));
                    break;
                case 4:
                    //undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation
                    // Ctrl + Z
                    if (!stack.isEmpty()){
                        stringBuilder = new StringBuilder(stack.pop());
                    }

                    break;
            }
        }
    }
}
