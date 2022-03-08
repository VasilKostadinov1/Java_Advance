package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tasks = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> threads = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int taskToKill = Integer.parseInt(scanner.nextLine());

        int killerThread = 0;
        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int task = tasks.pollLast();
            if(task == taskToKill) {
                killerThread = threads.peekFirst();
                break;
            }
            int thread = threads.pollFirst();

            if(thread < task) {
                tasks.addLast(task);
                continue;
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", killerThread, taskToKill);
        for (int thread : threads)
            System.out.printf("%d ", thread);


    }
    }

