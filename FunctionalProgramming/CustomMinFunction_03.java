package FunctionalProgramming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).min().orElse(0);
        System.out.println(i);

//        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        Function<int[], Integer> findMin = e -> Arrays.stream(e).min().getAsInt();
//        System.out.println(findMin.apply(numbers));
    }
}
