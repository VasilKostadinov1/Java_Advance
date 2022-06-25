package Exam_25June_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem1_ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> queueMilk = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> stackCacaoPowder = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(stackCacaoPowder::push);

        int milk = 0;
        int dark = 0;
        int baking = 0;

        while (!queueMilk.isEmpty() && !stackCacaoPowder.isEmpty()) {
            //If the sum of their values is equal to any of the items in the table below
            //remove both the liquid and the ingredient
            double valueMilk = queueMilk.peek();
            double valueCacao = stackCacaoPowder.peek();

            double cacaoPercentage = (valueCacao / (valueMilk + valueCacao)) * 100;

            if (cacaoPercentage == 30) {
                milk++;
                queueMilk.poll();
                stackCacaoPowder.pop();


            } else if (cacaoPercentage == 50) {
                dark++;
                queueMilk.poll();
                stackCacaoPowder.pop();

            } else if (cacaoPercentage == 100) {
                baking++;
                queueMilk.poll();
                stackCacaoPowder.pop();

            } else { // Otherwise, remove only the liquid and increase the value of the ingredient by 3.
                stackCacaoPowder.pop();
                queueMilk.poll();
                queueMilk.offer(valueMilk + 10);
//                valueIngredients += 3;
//                stackIngredients.push(valueIngredients);
            }
        }
        //...at least one of each of the foods..
        if (milk != 0 && dark != 0 && baking != 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        if (baking > 0) {
            System.out.printf("# Baking Chocolate --> %d%n", baking);
        }
        if (dark > 0) {
            System.out.printf("# Dark Chocolate --> %d%n", dark);
        }
        if (milk > 0) {
            System.out.printf("# Milk Chocolate --> %d%n", milk);
        }



    }
}
