package SetsAndMapsAdvance_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsInfo = new TreeMap<>();
        String input;
        while (!"Revision".equals(input = scanner.nextLine())) {
            String[] inputData = input.split(", ");
            String shop = inputData[0];
            String product = inputData[1];
            shopsInfo.putIfAbsent(shop, new LinkedHashMap<>());
            shopsInfo.get(shop).putIfAbsent(product, Double.parseDouble(inputData[2]));
        }
        shopsInfo.forEach((key, value) -> {
            System.out.printf("%s->%n", key);
            value.forEach((key1, value1) ->
                    System.out.printf("Product: %s, Price: %.1f%n", key1, value1));
        });
    }
}
