package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //First in, last out - Stack - push, pop
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                        .split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        //First in, first in - Queue - offer, poll
        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int targetValue = Integer.parseInt(scanner.nextLine());

        while (targetValue != 0) {
            int currentTask = tasks.peek();
            int currentThread = threads.peek();

            //If the thread value is greater than or equal to the task value,
            // the task and thread get removed.
            if (currentTask != targetValue) {
                if (currentThread >= currentTask) {
                    tasks.pop();
                    //If the thread value is less than the task value,
                    // the thread gets removed, but the task remains.
                }
                threads.pop();
            }else{
                System.out.printf("Thread with value %d killed task %d%n", currentThread, currentTask);
                break;
            }
        }
        for (Integer t : threads) {
            System.out.print(t + " ");
        }

    }
}
