package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquet2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tulipsStack::push);
        ArrayDeque<Integer> daffodilsQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int totalSum = 0;
        int bouquets = 0;
        while (!daffodilsQueue.isEmpty() && !tulipsStack.isEmpty()) {
            int rose = daffodilsQueue.poll();
            int lily = tulipsStack.pop();

            int flowerSum = lily + rose;
            if (flowerSum == 15) {
                bouquets++;
            } else if (flowerSum < 15) {
                totalSum += flowerSum;
            } else {
                while (lily + rose > 15) {
                    lily -= 2;
                    if (lily + rose == 15) {
                        bouquets++;
                    } else if (lily + rose < 15) {
                        totalSum += lily + rose;
                    }
                }
            }
        }
        while (totalSum >= 15) {
            bouquets++;
            totalSum -= 15;
        }
        if (bouquets >= 5) {
            System.out.println("You made it! You go to the competition with " + bouquets + " bouquets!");
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }

    }
}
