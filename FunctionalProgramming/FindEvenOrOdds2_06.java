package FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindEvenOrOdds2_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .limit(2)
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        IntStream
                .range(range[0], range[1] + 1)
                .filter(i -> command.equals("odd") == (i % 2 != 0))
                .forEach(e -> System.out.printf("%d ", e));
    }
}
