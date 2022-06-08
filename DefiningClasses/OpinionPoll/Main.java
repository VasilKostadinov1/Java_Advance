package DefiningClasses.OpinionPoll_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String data = scanner.nextLine();
            String[] tokens = data.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            if (age > 30) {
                people.add(person); // add "person" - the new Object in the list, not "name" !!!!
            }
        }
        people.sort(Comparator.comparing(Person::getName));
        people.forEach(e -> System.out.printf("%s - %d%n", e.getName(), e.getAge()));

        /*people
                .stream().filter(e -> e.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge())); */

    }

}
