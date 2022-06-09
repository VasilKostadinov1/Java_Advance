package Generics.GenericSwapMethodString_03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        IntStream.range(0, n).mapToObj(i -> scanner.nextLine()).forEach(box::add);
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        box.swap(indexes[0],indexes[1]);
        System.out.println(box.toString());
    }
}
