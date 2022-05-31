package FunctionalProgramming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //using a simple Function<Integer[], Integer[]>.
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    numbers = addToArray.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyToArray.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractToArray.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }

    public static Function<int[], int[]> addToArray = e -> Arrays.stream(e).map(n -> n += 1).toArray();
    public static Function<int[], int[]> subtractToArray = e -> Arrays.stream(e).map(n -> n -= 1).toArray();
    public static Function<int[], int[]> multiplyToArray = e -> Arrays.stream(e).map(n -> n *= 2).toArray();
    public static Consumer<int[]> printer = e -> Arrays.stream(e).forEach(s -> System.out.print(s + " "));
}
