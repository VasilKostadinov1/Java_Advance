package SetsAndMapsAdvance_Lab;

import java.util.*;

public class AverageStudentGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);
        }
        studentsGrades.forEach((key, value) -> {
            System.out.printf("%s -> ", key);
            value.forEach(v -> System.out.printf("%.2f ", v));
            System.out.printf("(avg: %.2f)%n", getAverage(value));
        });
    }

    private static Double getAverage(List<Double> value) {
        double average = 0.0;
        for (Double aDouble : value) {
            average += aDouble;
        }
        return average / value.size();

    }
}
