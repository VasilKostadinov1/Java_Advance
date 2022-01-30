package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TrojanInvasion_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waves = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> defenders = Arrays.stream(scanner.nextLine().split("\\s+"))    // queue
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> attackers = new ArrayDeque<>();                                 // stack

        for (int i = 1; i <= waves && !defenders.isEmpty(); i++) {
            // to be inside for, as otherwise not working.
            Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(attackers::push);

            if (i % 3 == 0) {
                int additionalDefender = Integer.parseInt(scanner.nextLine());
                defenders.offer(additionalDefender);
            }
            while (!defenders.isEmpty() && !attackers.isEmpty()) {

                int attacker = attackers.pop();
                int defender = defenders.poll();

                if (attacker > defender) {
                    attacker -= defender;
                    attackers.push(attacker);
                } else if (attacker < defender) {
                    defender -= attacker;
                    defenders.addFirst(defender);
                }
            }
        }
        if (defenders.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.printf("Warriors left: %s%n",
                    String.join(", ", attackers.toString())
                            .replaceAll("\\[|\\]",""));
        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.printf("Plates left: %s%n", String.join(", ", defenders.toString())
                    .replaceAll("\\[|\\]",""));
        }


    }
}
