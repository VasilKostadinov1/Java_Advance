package FunctionalProgramming_Lab;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split("\\s+");
        int lower = Integer.parseInt(token[0]);
        int upper = Integer.parseInt(token[1]);
        String oddOrEven = scanner.nextLine();

        Predicate<Integer> filter = getFilter(oddOrEven);
        Consumer<Integer> printer = x -> System.out.print(x + " ");

        IntStream.rangeClosed(lower, upper)
                .boxed()   // boxed : from primitive to Wrapper class
                .filter(filter)
                .forEach(printer);
    }

    private static Predicate<Integer> getFilter(String oddOrEven) {
        if (oddOrEven.equals("odd")) {
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }


}
