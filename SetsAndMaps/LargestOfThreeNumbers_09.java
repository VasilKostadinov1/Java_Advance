package SetsAndMapsAdvance_Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestOfThreeNumbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println(); */

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)                        // solution 2
                .sorted(Comparator.reverseOrder()).limit(3).forEach(e -> System.out.print(e + " "));
    }
}
