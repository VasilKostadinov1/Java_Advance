package EXAMs;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class BakeryShop_01_Feb22_Csharp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> queueWater = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> stackFlour = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(stackFlour::push);

        int countCroissant = 0, countMuffin = 0, countBaguette = 0, countBagel = 0;

        Map<String, Integer> bakery = new TreeMap<>();
        bakery.put("Croissant", 0);
        bakery.put("Muffin", 0);
        bakery.put("Baguette", 0);
        bakery.put("Bagel", 0);

        while (!queueWater.isEmpty() && !stackFlour.isEmpty()) {
            double valueWater = queueWater.poll();  //remove both the water and the flour
            double valueFlour = stackFlour.pop();

            double percentage = (valueWater / (valueWater + valueFlour)) * 100;  //(16.8 + 25.2 = 42; (16.8 * 100)/42 = 40% water)
            if (percentage == 50) {
                //countCroissant++;
                bakery.put("Croissant", bakery.get("Croissant") + 1);
            } else if (percentage == 40) {
                //countMuffin++;
                bakery.put("Muffin", bakery.get("Muffin") + 1);
            } else if (percentage == 30) {
                //countBaguette++;
                bakery.put("Baguette", bakery.get("Baguette") + 1);
            } else if (percentage == 20) {
                //countBagel++;
                bakery.put("Bagel", bakery.get("Bagel") + 1);
            } else { //If none of the products could be made, you should create the best-selling bakery product which is Croissant
                double flourReduced = valueFlour - valueWater;
                bakery.put("Croissant", bakery.get("Croissant") + 1);
                //countCroissant++;
                //The water is removed, and all the excessive flour should be inserted back into the collection
                stackFlour.push(flourReduced);
                queueWater.poll();
            }
        } // if "print in descending " is not needed, we can use - below 2 line for print
//        System.out.printf("Croissant : %d%nMuffin: %d%nBaguette: %d%nBagel: %d%n",
//                countCroissant, countMuffin, countBaguette, countBagel);

        // ordered by amount baked descending, then by product name alphabetically:
        bakery.entrySet().stream().sorted((h1, h2) -> Integer.compare(h2.getValue(), h1.getValue()))
                .forEach(baked -> {
                    if (baked.getValue() > 0) {
                        System.out.printf("%s: %d%n", baked.getKey(), baked.getValue());
                    }
                });

        if (queueWater.isEmpty()) {
            System.out.println("Water left: None");
        } else {  // "Water left: { water1}, { water2}, { water3}, (…)"
            //System.out.printf("Water left: %s%n", queueWater.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            DecimalFormat df = new DecimalFormat("0.##");
            //System.out.println(df.format(1.00d)); // -> 1
            System.out.printf("Water left: %s%n", queueWater.stream().map(df::format).collect(Collectors.joining(", ")));

        }
        if (stackFlour.isEmpty()) {
            System.out.println("Flour left: None");
        } else {
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.printf("Flour left: %s%n", stackFlour.stream().map(df::format).collect(Collectors.joining(", ")));
            for (Double w : queueWater) {
                System.out.printf("Water left: %s%n",w);
            }
        }


    }
}
