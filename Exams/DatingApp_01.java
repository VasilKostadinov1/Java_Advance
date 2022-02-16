package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(maleStack::push);

        ArrayDeque<Integer> femaleQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;
        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {

            int female = femaleQueue.peek();
            int male = maleStack.peek();

            if (female <= 0) {          // equal or < of 0, remove him/her
                femaleQueue.poll();
                continue;
            } else if (male <= 0) {
                maleStack.pop();
                continue;
            }
            if (female % 25 == 0) {   // divisible by 25, remove him/her and the next person
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            } else if (male % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
                continue;
            }
            if (female == male) {    // are equal ...
                matches++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }

        }
        System.out.printf("Matches: %d%n", matches);
        System.out.println("Males left: " + formatArrayDeque(maleStack));
        System.out.println("Females left: " + formatArrayDeque(femaleQueue));

    }

    private static int removeWhileValueIsNotGreaterThanZero(int number, ArrayDeque<Integer> deque) {
        while (number <= 0 && !deque.isEmpty()) {
            number = deque.removeFirst();
        }
        return number;
    }

    private static String formatArrayDeque(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return "none";
        }
        return deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
