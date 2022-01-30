package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class SummerCocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))         // Queue
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> freshnessLevel = Arrays.stream(scanner.nextLine().split("\\s+"))      // Stack
                .map(Integer::parseInt).collect(Collectors.toList());

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()) {
            int bucket = ingredients.get(0);  // Queue
            if (bucket == 0) {
                ingredients.remove(0);
                continue;
            }
            int freshLevel = freshnessLevel.get(freshnessLevel.size() - 1);  // Stack
            int totalFreshnessLevel = bucket * freshLevel;
            switch (totalFreshnessLevel) {
                case 150:
                    addCocktail(cocktails, "Mimosa");
                    removeParts(freshnessLevel, ingredients);
                    break;
                case 250:
                    addCocktail(cocktails, "Daiquiri");
                    removeParts(freshnessLevel, ingredients);
                    break;
                case 300:
                    addCocktail(cocktails, "Sunshine");
                    removeParts(freshnessLevel, ingredients);
                    break;
                case 400:
                    addCocktail(cocktails, "Mojito");
                    removeParts(freshnessLevel, ingredients);
                    break;
                default:
                    freshnessLevel.remove(freshnessLevel.size() - 1);
                    int ingredient = ingredients.remove(0);
                    ingredients.add(ingredient + 5);
                    break;
            }
        }

        if (cocktails.size() == 4) {
            System.out.println("Party time");
        } else {
            System.out.println("What a pity");
        }
        if (!ingredients.isEmpty()) {
            int sum = ingredients.stream().mapToInt(Integer::valueOf).sum();
            System.out.println(sum);
        }
        cocktails.forEach((k, v) -> System.out.printf("# %s -> %d%n", k, v));
        //cocktails.entrySet().stream().forEach(e-> System.out.printf("# %s -> %d",e.getKey(),e.getValue()));

        //10 10 12 8 10 12
        //25 15 50 25 25 15
    }

    private static void removeParts(List<Integer> freshnessLevel, List<Integer> ingredients) {
        ingredients.remove(0);                             // Queue
        freshnessLevel.remove(freshnessLevel.size() - 1);    // Stack
    }

    private static void addCocktail(Map<String, Integer> cocktails, String currentCocktail) {
        if (cocktails.containsKey(currentCocktail)) {
            int count = cocktails.get(currentCocktail);
            cocktails.put(currentCocktail, count + 1);
        } else {
            cocktails.put(currentCocktail, 1);
        }
    }
}
