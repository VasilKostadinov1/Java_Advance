package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SummerCocktails_AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshnessStack::push);

        int pearSour = 0;
        int harvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (!freshnessStack.isEmpty() && !ingredientsQueue.isEmpty()) {
            // The total freshness level is calculated by their multiplication
            int sum = freshnessStack.peek() * ingredientsQueue.peek();
            //If the product of this operation equals one of the levels described in the table, you make the cocktail and remove both
            if (sum == 150) {             // make the cocktail and remove both
                pearSour++;
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 250) {
                harvest++;
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 300) {
                appleHinny++;
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 400) {
                highFashion++;
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
                /*Integer ingredient = ingredientsQueue.poll();              // remove current
                ingredient += 5;                                             // increase it with 5
                ingredientsQueue.offer(ingredient);*/
            }
        }
        // make at least four cocktails - one of each type.!!! => "&&"
        if (pearSour > 0 && harvest > 0 && highFashion > 0 && appleHinny > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
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

        //ordered alphabetically - manually
        if (appleHinny >= 1) {
            System.out.printf("# Apple Hinny --> %d%n", appleHinny);
        }
        if (highFashion >= 1) {
            System.out.printf("# High Fashion --> %d%n", highFashion);
        }
        if (pearSour >= 1) {
            System.out.printf("# Pear Sour --> %d%n", pearSour);
        }
        if (harvest >= 1) {
            System.out.printf("# The Harvest --> %d%n", harvest);
        }
    }
}
