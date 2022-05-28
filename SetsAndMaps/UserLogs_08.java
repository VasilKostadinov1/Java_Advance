package SetAndMapsAdvance_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> usersInfo = new TreeMap<>();
        //Attacker        IP      counter
        String input;
        while (!"end".equals(input = scanner.nextLine())) {
            String[] inputData = input.split("\\s+");
            String userName = inputData[2].split("=")[1];
            String ipAddress = inputData[0].split("=")[1];
            usersInfo.putIfAbsent(userName, new LinkedHashMap<>());
            usersInfo.get(userName).put(ipAddress, !usersInfo.get(userName).containsKey(ipAddress)
                    ? 1 : usersInfo.get(userName).get(ipAddress) + 1);
        }
        usersInfo.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            int count = 1;
            for (var innerMap : value.entrySet()) {
                String output = String.format(count < value.entrySet().size()
                        ? "%s => %d, " : "%s => %d.%n", innerMap.getKey(), innerMap.getValue());
                System.out.printf("%s", output);
                count++;
            }
        });
    }
}
