package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshnessStack::push);
        Map<String, Integer> sumOfCocktails = new TreeMap<>();
        sumOfCocktails.put("Pear Sour", 0);
        sumOfCocktails.put("The Harvest", 0);
        sumOfCocktails.put("Apple Hinny", 0);
        sumOfCocktails.put("High Fashion", 0);
        while (!freshnessStack.isEmpty() && !ingredientsQueue.isEmpty()) {
            int sum = freshnessStack.peek() * ingredientsQueue.peek();
            if (sum == 150) {
                sumOfCocktails.put("Pear Sour", sumOfCocktails.get("Pear Sour") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 250) {
                sumOfCocktails.put("The Harvest", sumOfCocktails.get("The Harvest") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 300) {
                sumOfCocktails.put("Apple Hinny", sumOfCocktails.get("Apple Hinny") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 400) {
                sumOfCocktails.put("High Fashion", sumOfCocktails.get("High Fashion") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (ingredientsQueue.peek() == 0) {
                ingredientsQueue.poll();
            } else {
                freshnessStack.pop();
                ingredientsQueue.offerLast(ingredientsQueue.poll() + 5);
            }
        }
        if (sumOfCocktails.get("Pear Sour") > 0 && sumOfCocktails.get("The Harvest") > 0 && sumOfCocktails.get("Apple Hinny")
                > 0 && sumOfCocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientsQueue.isEmpty()) {
            int sum = 0;
            for (Integer integer : ingredientsQueue) {
                sum += integer;
            }
            System.out.println("Ingredients left: " + sum);
        }
        sumOfCocktails.forEach((key, value) -> {
            if (value > 0) {
                System.out.printf("# %s --> %d%n", key, value);
            }
        });

    }
}
