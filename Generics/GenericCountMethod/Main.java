package Generics.GenericCountMethodString_05;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        IntStream.range(0, n).mapToObj(i -> scanner.nextLine()).forEach(box::add);
        System.out.println(box.countGraterElements(scanner.nextLine()));
    }
}
