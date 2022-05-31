package FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Double, Double> addVat = d -> d * 1.2;
        //UnaryOperator<Double> addVat = d -> d * 1.2;
        //interface UnaryOperator<T> extends Function<T, T>  !!!

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(x -> System.out.printf("%.2f%n", x));

//        Function<String, Double> mapWithVAT = str -> Double.parseDouble(str) * 1.2;
//        Arrays.stream(scanner.nextLine().split(",\\s+"))
//                .map(mapWithVAT).forEach(e -> System.out.printf("%.2f%n", e));
    }
}
