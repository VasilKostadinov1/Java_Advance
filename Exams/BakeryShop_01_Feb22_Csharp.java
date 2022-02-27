package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BakeryShop_01_Feb22_Csharp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Double> queueWater = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> stackFlour = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(stackFlour::push);

        int countCroissant = 0, countMuffin = 0, countBaguette = 0, countBagel = 0;

        while (!queueWater.isEmpty() && !stackFlour.isEmpty()) {
            double valueWater = queueWater.poll();  //remove both the water and the flour
            double valueFlour = stackFlour.pop();
            double percentage = (valueWater / (valueWater + valueFlour)) * 100;
            if (percentage == 50) {
                countCroissant++;
            } else if (percentage == 40) {
                countMuffin++;
            } else if (percentage == 30) {
                countBaguette++;
            } else if (percentage == 20) {
                countBagel++;
            } else {
                double flourReduced = valueFlour - valueWater;
                countCroissant++;
                stackFlour.push(flourReduced);
                queueWater.poll();
            }
        }

        System.out.printf("Croissant : %d%nMuffin: %d%nBaguette: %d%nBagel: %d%n",
                countCroissant, countMuffin, countBaguette, countBagel);

        if (queueWater.isEmpty()) {
            System.out.println("Water left: None");
        } else {
            System.out.printf("Water left: %s%n", queueWater.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (stackFlour.isEmpty()) {
            System.out.println("Flour left: None");
        } else {
            System.out.printf("Flour left: %s%n", stackFlour.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

    }
}
