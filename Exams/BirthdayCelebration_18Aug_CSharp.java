package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BirthdayCelebration_18Aug_CSharp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> queueGuests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackPlates = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stackPlates::push);

        int wastedGrams = 0;
        while (!queueGuests.isEmpty() && !stackPlates.isEmpty()) {
            int plates = stackPlates.peek();
            int guests = queueGuests.peek();
            int diff = plates - guests;

            //When a guest's integer value reaches 0 or less, it gets removed
            if (guests <= 0) {
                queueGuests.poll();
                continue;
            }
            //If a plate's value is greater or equal to the guest's current value
            if (plates >= guests) {
                stackPlates.pop();
                queueGuests.poll();
                wastedGrams += diff;
            } else {
                //It is possible that the current guest's value is greater than the current food's value
                //In that case you pick plates until you reduce the guest's integer value to 0 or less. ?
                stackPlates.pop();
                queueGuests.poll();
                queueGuests.offerFirst(guests-plates);
            }
        }
        if (queueGuests.isEmpty()) {
            System.out.printf("Plates: %s%n", stackPlates.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        } else {
            System.out.printf("Guests: %s%n", queueGuests.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        System.out.printf("Wasted grams of food: %d", wastedGrams);

    }
}
