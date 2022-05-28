package SetAndMapsAdvance_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> output = new LinkedHashMap<>();
        String input =scanner.nextLine();

        while (!"stop".equals(input)) {
            String resources = input;
            int value = Integer.parseInt(scanner.nextLine());
            output.put(resources, !output.containsKey(resources) ? value : output.get(resources) + value);

//            output.putIfAbsent(resources, 0);
//            output.put(resources, output.get(resources) + value);
            input =scanner.nextLine();
        }
        output.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));

    }
}
