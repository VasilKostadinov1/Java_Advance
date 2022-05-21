package StacksAndQueues_Exercises;

import java.util.Scanner;

public class RecursiveFibonacci_06 {

    public static long[] fibonacci;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        fibonacci = new long[n + 1];
        System.out.println(fib(n));
    }

    private static long fib(int n) {
        if (n <= 1) {
            return 1;
        }

        if (fibonacci[n] != 0) {
            return fibonacci[n];
        }
        return fibonacci[n] = fib(n - 1) + fib(n - 2);
    }
}
