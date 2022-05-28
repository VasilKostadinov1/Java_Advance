package SetAndMapsAdvance_Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];
            phoneBook.put(name, phone);

            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            if (phoneBook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phoneBook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scanner.nextLine();

        }
    }
}
