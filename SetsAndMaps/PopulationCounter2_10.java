package SetAndMapsAdvance_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter2_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> cities = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String town = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);
            if (!cities.containsKey(country)) {
                cities.put(country, new LinkedHashMap<>());
            }
            cities.get(country).put(town, population);
            input = scanner.nextLine();
        }

        cities.entrySet().stream().sorted((c1, c2) -> {
            long p1 = c1.getValue().values().stream().mapToInt(i -> i).sum();
            long p2 = c2.getValue().values().stream().mapToInt(l -> l).sum();

            return Long.compare(p2, p1);
        }).forEach(c -> {
            Long totalPopulation = c.getValue().values().stream().mapToLong(v -> v).sum();
            System.out.printf("%s (total population: %d)%n", c.getKey(), totalPopulation);

            Map<String, Integer> childMap = c.getValue();
            childMap.entrySet().stream().sorted((e1, e2) -> {
                return Long.compare(e2.getValue(), e1.getValue());
            }).forEach(s -> {
                System.out.printf("=>%s: %d%n", s.getKey(), s.getValue());
            });
        });
    }
}
