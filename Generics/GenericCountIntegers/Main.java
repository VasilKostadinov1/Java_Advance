package Generics.GenericCountMethodDouble_06;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        final int n = Integer.parseInt(scan.nextLine());
        Box<Double> box = new Box<>();
        IntStream.range(0, n).mapToObj(i -> Double.parseDouble(scan.nextLine())).forEach(box::add);
        System.out.println(box.countGraterElements(Double.parseDouble(scan.nextLine())));
    }
}
