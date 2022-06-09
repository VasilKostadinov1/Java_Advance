package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class Masterchef_26June21_CSh_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshnessStack::push);

        Map<String, Integer> sumOfCocktails = new TreeMap<>();  // multiplication
        sumOfCocktails.put("Dipping sauce", 0);
        sumOfCocktails.put("Green salad", 0);
        sumOfCocktails.put("Chocolate cake", 0);
        sumOfCocktails.put("Lobster", 0);

        while (!freshnessStack.isEmpty() && !ingredientsQueue.isEmpty()) {
            // The total freshness level is calculated by their multiplication
            int sum = freshnessStack.peek() * ingredientsQueue.peek();
            //If the product of this operation equals one of the levels described in the table, you make the cocktail and remove both
            if (sum == 150) {             // make the cocktail and remove both
                sumOfCocktails.put("Dipping sauce", sumOfCocktails.get("Dipping sauce") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 250) {
                sumOfCocktails.put("Green salad", sumOfCocktails.get("Green salad") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 300) {
                sumOfCocktails.put("Chocolate cake", sumOfCocktails.get("Chocolate cake") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 400) {
                sumOfCocktails.put("Lobster", sumOfCocktails.get("Lobster") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
                // In case you have an ingredient with a value of 0 you have to remove it and continue mixing...
            } else if (ingredientsQueue.peek() == 0) {
                ingredientsQueue.poll();
            } else {
                // Otherwise, you should remove the freshness level, increase the ingredient value by 5,
                // then remove it from the first position and add it at the end
                freshnessStack.pop();
                ingredientsQueue.offerLast(ingredientsQueue.poll() + 5);   // offerLast = offer
                /*Integer ingredient = ingredientsQueue.poll();
                ingredient += 5;
                ingredientsQueue.offer(ingredient);*/
            }
        }
        // make at least four cocktails - one of each type.!!! => "&&"
        if (sumOfCocktails.get("Dipping sauce") > 0 && sumOfCocktails.get("Green salad") > 0 && sumOfCocktails.get("Chocolate cake")
                > 0 && sumOfCocktails.get("Lobster") > 0) {
            System.out.println("Applause! The judges are fascinated by your dishes! ");
        } else {
            System.out.println("You were voted off. Better luck next year.");
        }
        // print the sum of the ingredients only if they are left any
        if (!ingredientsQueue.isEmpty()) {
            /*int sum = 0;
            for (Integer integer : ingredientsQueue) {
                sum += integer;
            }
            System.out.println("Ingredients left: " + sum); */
            System.out.println("Ingredients left: " + ingredientsQueue.stream().mapToInt(Integer::valueOf).sum());
        }
        // print the cocktails you have made at least once, ordered alphabetically
        sumOfCocktails.forEach((key, value) -> {
            if (value > 0) {  // made at least once !
                System.out.printf("# %s --> %d%n", key, value);
            }
        });
        //ordered alphabetically - manually
//        if (sumOfCocktails.get("Apple Hinny") > 0) {
//            System.out.printf("# Apple Hinny --> %d%n", sumOfCocktails.get("Apple Hinny"));
//        }
//        if (sumOfCocktails.get("High Fashion") > 0) {
//            System.out.printf("# High Fashion --> %d%n", sumOfCocktails.get("High Fashion"));
//        }
    }
}
