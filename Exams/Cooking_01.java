package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueLiquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stackIngredients::push);

        int countBread = 0, countCake = 0, countPastry = 0, countFruit = 0;

        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {
            int valueLiquids = queueLiquids.poll();
            int valueIngredients = stackIngredients.pop();
            if (valueLiquids + valueIngredients == 25) {
                countBread++;
            }else if (valueLiquids + valueIngredients == 50) {
                countCake++;
            }else if (valueLiquids + valueIngredients == 75) {
                countPastry++;
            }else if (valueLiquids + valueIngredients == 100) {
                countFruit++;
            }else { // Otherwise, remove only the liquid and increase the value of the ingredient by 3.
                stackIngredients.push(valueIngredients+3);
            }
        }
        if (countBread != 0 && countCake != 0 && countFruit != 0 && countPastry != 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (queueLiquids.isEmpty()) {  // print all liquids you have left:
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s%n", queueLiquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (stackIngredients.isEmpty()) {  // print all physical materials you have left:
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s%n", stackIngredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.printf("Bread: %d%nCake: %d%nFruit Pie: %d%nPastry: %d%n", countBread, countCake, countFruit, countPastry);

    }
}
