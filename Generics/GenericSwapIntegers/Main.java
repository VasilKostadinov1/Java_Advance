package Generics.GenericSwapMethodInteger_04;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        final int n = Integer.parseInt(scan.nextLine());
        Box<Integer> box = new Box<>();
        IntStream.range(0, n).map(i -> Integer.parseInt(scan.nextLine())).forEach(box::add);
        int[] indexes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        box.swap(indexes[0],indexes[1]);
        System.out.println(box.toString());
    }
}
