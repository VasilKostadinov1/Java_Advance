package FunctionalProgramming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = Integer.parseInt(scanner.nextLine());

        //length is less or equal the passed integer
        Predicate<String> predicate = p -> p.length() <= len;
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(predicate)
                .forEach(System.out::println);

        //Arrays.stream(scanner.nextLine().split("\\s+")).filter(p -> p.length() <= len).forEach(System.out::println);


    }
}
