package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectsQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casingsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(casingsStack::push);

        TreeMap<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        while (!effectsQueue.isEmpty() && !casingsStack.isEmpty()) {
            if (hasAllBombs(bombs)) {
                break;
            }

            int effect = effectsQueue.peek();
            int casing = casingsStack.pop();  // we remove from the casing in both cases: remove or decrease !!!

            int sum = effect + casing;
            if (sum == 40) {
                effectsQueue.poll();
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
            } else if (sum == 60) {
                effectsQueue.poll();
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
            } else if (sum == 120) {
                effectsQueue.poll();
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
            } else {
                casingsStack.push(casing - 5);  // decrease the value of the bomb casing by 5
            }
        }
        if (hasAllBombs(bombs)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        String effectOutput = "Bomb Effects: " + (effectsQueue.isEmpty()
                ? "empty" : effectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(effectOutput);

        String casingOutput = "Bomb Casings: " + (casingsStack.isEmpty()
                ? "empty" : casingsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(casingOutput);

        for (var entry : bombs.entrySet()) {
            System.out.println(String.format("%s: %d", entry.getKey(),entry.getValue()));
        }
    }

    private static boolean hasAllBombs(TreeMap<String, Integer> bombs) {   // Ezio needs three of each of the bomb types.
        return bombs.get("Cherry Bombs") >= 3 && bombs.get("Datura Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3;
    }
}
