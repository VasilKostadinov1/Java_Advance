package FunctionalProgramming_Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);

        Predicate<Integer> predicate = p -> p % n != 0;
        Consumer<Integer> consumer = i -> System.out.print(i + " ");
        numbers.stream().filter(predicate).forEach(consumer);

        //numbers.stream().filter(p -> p % n != 0).forEach(i -> System.out.print(i + " "));

    }

}
