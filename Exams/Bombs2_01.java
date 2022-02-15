package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effects = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(casings::push);
        int countDatura = 0, countCherry = 0, countSmoke = 0;

        while (!effects.isEmpty() && !casings.isEmpty() && (countCherry < 3 || countSmoke < 3 || countDatura < 3)) {
            int currentEffects = effects.poll();
            int currentCasings = casings.pop();
            if (currentEffects + currentCasings == 40) {
                countDatura++;
            } else if (currentEffects + currentCasings == 60) {
                countCherry++;
            } else if (currentEffects + currentCasings == 120) {
                countSmoke++;
            } else {
                casings.push(currentCasings - 5);
                effects.offerFirst(currentEffects);
            }
        }
        if (countCherry >= 3 && countSmoke >= 3 && countDatura >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s%n", String.join(", ", effects.toString().replaceAll("[\\[\\]]", "")));
            //System.out.printf("Bomb Effects: %s%n", effects.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (casings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s%n", String.join(", ", casings.toString().replaceAll("[\\[\\]]", "")));
        }
        System.out.printf("Cherry Bombs: %d%nDatura Bombs: %d%nSmoke Decoy Bombs: %d%n", countCherry, countDatura, countSmoke);
    }
}
