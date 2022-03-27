package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop2_01_withMAP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queueLiquids = new ArrayDeque<>();
        Deque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(e -> queueLiquids.offer(e));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(e -> stackIngredients.push(e));

        Map<String, Integer> mapProducts = new LinkedHashMap<>();
        mapProducts.put("Biscuit", 0);
        mapProducts.put("Cake", 0);
        mapProducts.put("Pie", 0);
        mapProducts.put("Pastry", 0);

        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {
            int queueValue = queueLiquids.poll();
            int stackValue = stackIngredients.pop();
            int sum = stackValue + queueValue;
            if (sum == 25) {
                mapProducts.put("Biscuit", mapProducts.get("Biscuit") + 1);
            } else if (sum == 50) {
                mapProducts.put("Cake", mapProducts.get("Cake") + 1);
            } else if (sum == 75) {
                mapProducts.put("Pastry", mapProducts.get("Pastry") + 1);
            } else if (sum == 100) {
                mapProducts.put("Pie", mapProducts.get("Pie") + 1);
            } else {
                stackIngredients.push(stackValue + 3);
            }
        }
        boolean isWin = true;
        for (int value : mapProducts.values()) {
            if (value == 0) {
                isWin = false;
                break;
            }
        }
        if (isWin) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + queueLiquids.stream().map(e -> e.toString())
                    .collect(Collectors.joining(", ")));
        }
        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + stackIngredients.stream().map(e -> e.toString())
                    .collect(Collectors.joining(", ")));
        }
        for (var entry : mapProducts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
