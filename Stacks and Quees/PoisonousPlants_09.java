package StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoisonousPlants_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> plantsData = new ArrayList<>();

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPlants; i++) {
            int current = scanner.nextInt();
            plantsData.add(current);
        }
        ArrayDeque<Integer> removeElements = new ArrayDeque<>();

        int days = 0;
        boolean areRemoved = false;
        while (!areRemoved) {

            int removedElements = 0;
            for (int i = 0; i < plantsData.size() - 1; i++) {
                int currentElement = plantsData.get(i);
                int nextElement = plantsData.get(i + 1);

                if (currentElement < nextElement) {
                    removeElements.offer(nextElement);
                    removedElements++;
                }
            }
            if (removedElements == 0) {
                areRemoved = true;
            }
            while (!removeElements.isEmpty()) {
                int toBeRemoved = removeElements.poll();
                plantsData.remove(toBeRemoved);
            }
            days++;
        }
        System.out.println(days - 1);
    }
}
