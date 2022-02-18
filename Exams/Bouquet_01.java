package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class Bouquet_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    // 100/100 by myself

        ArrayDeque<Integer> stackTulip = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(stackTulip::push);

        ArrayDeque<Integer> queueDaffodil = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int countBouquets = 0;
        int storedSum = 0;
        while (!queueDaffodil.isEmpty() && !stackTulip.isEmpty()) {
            int firstItem = stackTulip.peek();
            int secondItem = queueDaffodil.peek();

            int sum = firstItem + secondItem;
            if (sum == 15) {
                countBouquets++;
                stackTulip.pop();
                queueDaffodil.poll();
            }
            if (sum < 15) {
                stackTulip.pop();
                queueDaffodil.poll();
                storedSum += sum;

            }
            while (sum > 15) {
                firstItem -= 2;
                sum -= 2;
                if (sum == 15) {
                    countBouquets++;
                    stackTulip.pop();
                    queueDaffodil.poll();
                } else if (sum < 15) {
                    storedSum += sum;
                    stackTulip.pop();
                    queueDaffodil.poll();
                }
            }
        }
        int moreBouquets = storedSum / 15;
        if (countBouquets == 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", countBouquets);
        } else {
            int neededBouquets = 5- countBouquets-moreBouquets;
            System.out.printf("You failed... You need more %d bouquets.", neededBouquets);
        }

    }
}
