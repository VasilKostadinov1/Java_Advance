package EXAMs;

import java.util.*;

public class ExcelFunction2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<List<String>> matrix = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("[,\\s]+");
            matrix.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(data))));
        }
        String[] line = scanner.nextLine().split(" ");
        switch (line[0]) {
            case "sort":
                sortMatrix(matrix, line[1]);
                break;
            case "hide":
                hide(matrix, line[1]);
                break;
            case "filter":
                filter(matrix, line[1], line[2]);
                break;
        }
    }

    private static void filter(List<List<String>> matrix, String headerName, String param) {
        int headerIndex = matrix.get(0).indexOf(headerName);
        System.out.println(print(matrix.get(0)));  // print header row

        matrix
                .stream().skip(1)
                .filter(rows->rows.get(headerIndex).contains(param))
                .forEach(row-> System.out.println(print(row)));

    }

    private static void hide(List<List<String>> matrix, String param) {
        int colToHide =matrix.get(0).indexOf(param);

        for (List<String> rows : matrix) {
            rows.remove(colToHide);
        }
        for (List<String> rows : matrix) {
            System.out.println(print(rows));
        }

    }

    private static void sortMatrix(List<List<String>> matrix, String param) {
        int headerIndex = matrix.get(0).indexOf(param);
        System.out.println(print(matrix.get(0)));   // print header row

        matrix
                .stream().skip(1)
                .sorted(Comparator.comparing(o -> o.get(headerIndex)))
                .forEach(rows -> System.out.println(print(rows)));
    }

    private static String print(List<String> matrix) {
        return String.join(" | ", matrix);
    }
}
