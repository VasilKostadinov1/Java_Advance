package FunctionalProgramming_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] token = scanner.nextLine().split(", ");
            String name = token[0];
            int age = Integer.parseInt(token[1]);
            people.put(name, age);
        }

        String ageCondition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Map.Entry<String, Integer>> ageFilter = getAgeFilter(age, ageCondition);

        people.entrySet().stream()
                .filter(ageFilter)
                .forEach(getFormatter(format));
    }

    private static Consumer<? super Map.Entry<String, Integer>> getFormatter(String format) {
        if (format.equals("name")) {
            return entry -> System.out.println(entry.getKey());
        } else if (format.equals("age")) {
            return entry -> System.out.println(entry.getValue());
        }
        return entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(int age, String ageCondition) {
//        if (ageCondition.equals("older")) {
//            return e -> e.getValue() >= age;
//        }
//        return e -> e.getValue() <= age;
        return ageCondition.equals("older")
                ? e -> e.getValue() >= age
                : e -> e.getValue() <= age;
    }
}
