package SetsAndMapsAdvance_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Set<Integer> firstPlayer = new LinkedHashSet<>(firstCards);
        Set<Integer> secondPlayer = new LinkedHashSet<>(secondCards);

//        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
//        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        int n = 50;
        while (n-- != 0 && (!firstPlayer.isEmpty() && !secondPlayer.isEmpty())) {
            int first = firstPlayer.iterator().next();
            int second = secondPlayer.iterator().next();
            firstPlayer.remove(first);
            secondPlayer.remove(second);
            if (first > second) {
                firstPlayer.add(first);
                firstPlayer.add(second);
            } else if (second > first) {
                secondPlayer.add(first);
                secondPlayer.add(second);
            }
        }
        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");
        } else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }

    }

}
