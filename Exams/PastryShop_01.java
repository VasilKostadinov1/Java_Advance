package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryShop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredientsStack::push);
        int biscuit = 0;
        int cake = 0;
        int pie = 0;
        int pastry = 0;
        while (!ingredientsStack.isEmpty() && !liquidsQueue.isEmpty()) {
            int sum = liquidsQueue.peek() + ingredientsStack.peek();
            if (sum == 25) {
                biscuit++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 50) {
                cake++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 75) {
                pastry++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 100) {
                pie++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);

            }
        }
        String allCookedOrNot = biscuit >= 1 && cake >= 1 && pastry >= 1 && pie >= 1 ?
                "Great! You succeeded in cooking all the food!" :
                "What a pity! You didn't have enough materials to cook everything.";
        System.out.println(allCookedOrNot);
        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: " +
                    liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();

        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: " +
                    ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }
        System.out.printf("Biscuit: %d%nCake: %d%nPie: %d%nPastry: %d", biscuit, cake, pie, pastry);
    }
}
