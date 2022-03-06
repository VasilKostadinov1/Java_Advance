package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths_01_Bouquet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(liliesStack::push);
        ArrayDeque<Integer> rosesQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int totalSum = 0;
        int wreath = 0;
        while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()) {
            int rose = rosesQueue.poll();
            int lily = liliesStack.pop();
            int flowerSum = lily + rose;
            if (flowerSum == 15) {
                wreath++;
            } else if (flowerSum < 15) {
                totalSum += flowerSum;
            } else {
                while (lily + rose > 15) {
                    lily -= 2;
                    if (lily + rose == 15) {
                        wreath++;
                    } else if (lily + rose < 15) {
                        totalSum += lily + rose;
                    }
                }
            }
        }
        while (totalSum >= 15) {
            wreath++;
            totalSum -= 15;
        }
        if (wreath >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreath + " wreaths!");
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreath);
        }
    }
}

