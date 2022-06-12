package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class MealPlan2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // 2nd output is working !!!

        ArrayDeque<String> vegetablesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(x -> x.matches("(salad|soup|pasta|steak)")).forEach(vegetablesStack::offer);

        ArrayDeque<Integer> saladsQueues = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(saladsQueues::push);

        Map<String, Integer> vegetableCalories = new LinkedHashMap<String, Integer>() {{
            put("salad", 350);
            put("soup", 490);
            put("pasta", 680);
            put("steak", 790);
        }};

        int countMeals = 0;
        while (!vegetablesStack.isEmpty() && !saladsQueues.isEmpty()) {
            int currentSalad = saladsQueues.peek();

            while (currentSalad > 0 && !vegetablesStack.isEmpty()) {
                currentSalad -= vegetableCalories.get(vegetablesStack.poll());
                if (currentSalad < 0) {
                    saladsQueues.pop();
                }
                countMeals++;
            }
        }

        if (vegetablesStack.isEmpty()) {
            System.out.printf("John had %d meals.%n", countMeals);

            String collect = saladsQueues.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("For the next few days, he can eat %s calories.%n", collect);
        }
        else {
            System.out.printf("John ate enough, he had %d meals.%n",countMeals);
            System.out.printf("Meals left: %s%n", vegetablesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }

        //System.out.println(saladsQueues.toString().replaceAll("[\\[\\],]",""));
        //System.out.println(vegetablesStack.toString().replaceAll("[\\[\\],]",""));


    }
}
