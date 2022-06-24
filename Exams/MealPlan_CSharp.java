package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class MealPlan_CSharp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    // 1st input not working correctly !!!

        ArrayDeque<String> vegetablesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> caloriesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(caloriesStack::push);

        List<Integer> readySalad = new ArrayList<>();
        List<Integer> newReadySalad = new ArrayList<>();
        int count = 0;

        while (!vegetablesQueue.isEmpty() && !caloriesStack.isEmpty()) {
            //. A salad is considered ready, when its calorie value reaches 0. When the salad is ready, remove it from the collection
            int valueOfSalad = caloriesStack.pop();


            while (!vegetablesQueue.isEmpty() && valueOfSalad > 0) {
                //Each time you take a vegetable, you must reduce the amount of calories for the given salad with its calorie value
                //and remove it from the collection
                switch (vegetablesQueue.poll()) {
                    case "salad":
                        valueOfSalad -= 350;

                        count++;
                        break;
                    case "soup":
                        valueOfSalad -= 490;

                        count++;
                        break;
                    case "pasta":
                        valueOfSalad -= 680;
                        count++;
                        break;
                    case "steak":
                        valueOfSalad -= 790;
                        count++;
                        break;
                }

                if (valueOfSalad <= 0 && caloriesStack.size() >= 2) {  // half hard-coded
                    readySalad.add(-valueOfSalad);
                    caloriesStack.push(caloriesStack.removeFirst() + valueOfSalad);
                }
            }
        }
        //At last, print either the vegetables that are left, or the calories of the salads you couldn't prepare, depending on the case –

        if (vegetablesQueue.isEmpty()) {
            System.out.printf("John had %d meals.%n", count);
            System.out.printf("For the next few days, he can eat %s calories.%n",
                    caloriesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }
        if (caloriesStack.isEmpty()) {
            System.out.printf("John ate enough, he had %d meals.%n", count);
            System.out.printf("Meals left: %s%n",
                    vegetablesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

    }
}
