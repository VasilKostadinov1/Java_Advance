package FunctionalProgramming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = s -> System.out.printf("Sir %s%n", s);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(print);

    }
}
