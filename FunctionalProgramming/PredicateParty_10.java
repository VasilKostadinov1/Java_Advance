package FunctionalProgramming_Exercises;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {

    static List<String> names;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input;
        while (!"Party!".equals(input = scanner.nextLine())) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Double":
                    addOneMore(getPredicate(command));
                    break;
                case "Remove":
                    removeName(getPredicate(command));
                    break;
            }
        }
        Collections.sort(names);
        Consumer<List<String>> print = (s-> {
            if (s.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else {
                System.out.println(String.join(", ", s) + " are going to the party!");
            }
        });
        print.accept(names);
    }

    private static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    private static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(namesToAdd::add);
        names.addAll(namesToAdd);
    }

    private static Predicate<String> getPredicate(String[] command) {
        Predicate<String> predicate;
        if (command[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(command[2]);
        } else if (command[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(command[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(command[2]);
        }
        return predicate;
    }
}
