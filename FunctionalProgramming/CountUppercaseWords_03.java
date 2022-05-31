package FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Predicate<String> uppercase = s -> Character.isUpperCase(s.charAt(0));

        System.out.println(Arrays.stream(line.split(" ")).filter(uppercase).count());
        //System.out.println(Arrays.stream(line.split(" ")).filter(s -> Character.isUpperCase(s.charAt(0))).count());

        Arrays.stream(line.split(" ")).filter(uppercase).forEach(System.out::println);
    }
}
