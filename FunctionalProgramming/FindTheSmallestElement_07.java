package FunctionalProgramming_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getMinNum = l->l.lastIndexOf(l.stream().min(Integer::compareTo).get());
        System.out.println(getMinNum.apply(numbers));

    }
}
