package FunctionalProgramming_Lab;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge3_05 {

    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // Martin unfinished...

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = IntStream.range(0, n)
                .mapToObj(ignored -> {
                    String[] tokens = scanner.nextLine().split(", ");
                    return new Person(tokens[0], Integer.parseInt(tokens[1]));
                })
                .collect(Collectors.toList());
    }
}
