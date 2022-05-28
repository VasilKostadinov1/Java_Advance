package SetsAndMapsAdvance_Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guestList = new TreeSet<>();
        String input;
        while (!"PARTY".equals(input = scanner.nextLine())) {
            guestList.add(input);
        }
        while (!"END".equals(input = scanner.nextLine())) {
            guestList.remove(input);
        }
        System.out.printf("%s%n%s", guestList.size(), guestList.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
