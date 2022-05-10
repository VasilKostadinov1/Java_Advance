package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueLiquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stackIngredients::push);

        int countBread = 0, countCake = 0, countPastry = 0, countFruit = 0;

        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {
            //If the sum of their values is equal to any of the items in the table below
            //remove both the liquid and the ingredient
            int valueLiquids = queueLiquids.peek();
            int valueIngredients = stackIngredients.peek();

            if (valueLiquids + valueIngredients == 25) {
                countBread++;
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (valueLiquids + valueIngredients == 50) {
                countCake++;
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (valueLiquids + valueIngredients == 75) {
                countPastry++;
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (valueLiquids + valueIngredients == 100) {
                countFruit++;
                queueLiquids.poll();
                stackIngredients.pop();
            } else { // Otherwise, remove only the liquid and increase the value of the ingredient by 3.
                queueLiquids.poll();
                stackIngredients.pop();
                stackIngredients.push(valueIngredients + 3);
//                valueIngredients += 3;
//                stackIngredients.push(valueIngredients);
            }
        }
        if (countBread != 0 && countCake != 0 && countFruit != 0 && countPastry != 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        // print all liquids you have left:
        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s%n", queueLiquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        // print all physical materials you have left:
        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s%n", stackIngredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.printf("Bread: %d%nCake: %d%nFruit Pie: %d%nPastry: %d%n", countBread, countCake, countFruit, countPastry);
    }
}
