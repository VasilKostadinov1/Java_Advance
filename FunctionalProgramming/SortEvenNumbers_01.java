package FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Print the even numbers
        //Sort them in ascending order
        //Print them again.

        int[] numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .toArray();

        String evenNumbers = getCollect(numbers);
        System.out.println(evenNumbers);

        Arrays.sort(numbers);

        String sortedNumbers = getCollect(numbers);
        System.out.println(sortedNumbers);
    }

    private static String getCollect(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
