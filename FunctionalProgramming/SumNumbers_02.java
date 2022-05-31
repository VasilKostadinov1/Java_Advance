package FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Type parameters:
        //<T> – the type of the input to the function
        //<R> – the type of the result of the function

        String input = scanner.nextLine();
        Function<String, Integer> count = s -> Math.toIntExact(Arrays.stream(s.split(", ")).count());
        Function<String, Integer> sum = s -> Arrays.stream(s.split(", ")).mapToInt(Integer::parseInt).sum();
        System.out.println("Count = " + count.apply(input));
        System.out.println("Sum = " + sum.apply(input));

//        Function<String, Integer> count2 = s -> s.split(", ").length;
//        System.out.println("Count = " + count2.apply(input));

    }
}
