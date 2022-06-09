package Generics.GenericsBoxOfIntegers_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int digit = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(digit);
            System.out.println(box);
        }
    }
}
