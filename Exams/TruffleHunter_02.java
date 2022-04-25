package EXAMs;

import java.util.*;

public class TruffleHunter_02 {

    private static char[][] matrix;
    private static Map<String, Integer> vegetables;
    private static int countHarmed = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        readMatrix(scan, Integer.parseInt(scan.nextLine()));
        vegetables = new LinkedHashMap<>() {{ put("Black truffle", 0); put("Summer truffle",0); put("White truffle", 0);}};
        String input;
        int row, col;


        while (!"Stop the hunt".equals(input = scan.nextLine())) {
            String[] command = input.split("\\s+");
            row = Integer.parseInt(command[1]);
            col = Integer.parseInt(command[2]);

            if (command[0].equals("Collect")) {
                checkVegetable(row, col);
            } else {
                if (isValidIndexes(row, col)) {
                    if ("up".equals(command[3])) {
                        moveToNext(row, col, -2, "rows"); //It eats the given cell, skips the next, and eats the next one
                    } else if ("down".equals(command[3])) {
                        moveToNext(row, col, 2, "rows");
                    } else if ("left".equals(command[3])) {
                        moveToNext(row, col, -2, "cols");
                    } else if ("right".equals(command[3])) {
                        moveToNext(row, col, 2, "cols");
                    }
                }
            }
        }
//        int countBlack = 0;
//        int countSummer = 0;
//        int countWhite = 0;
        System.out.printf("Peter manages to harvest %d black, %d summer, and %d white truffles.%n",
                vegetables.get("Black truffle"), vegetables.get("Summer truffle"),vegetables.get("White truffle"));
        System.out.printf("The wild boar has eaten %d truffles.%n", countHarmed);
        printMatrix();
        //vegetables.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));


    }
    private static void moveToNext(int row, int col, int index, String direction) {
        while (isValidIndexes(row, col)) {
            checkCell(row, col);
            if (direction.equals("rows")) {
                row = Math.abs(row) + index;
            } else {
                col = Math.abs(col) + index;
            }
        }
    }

    private static void checkCell(int row, int col) {
        if (matrix[row][col] != '-') {  // change
            countHarmed++;
            matrix[row][col] = '-';     // change
        }
    }

    private static void checkVegetable(int row, int col) {
        if (isValidIndexes(row, col)) {
            char current = matrix[row][col];
            if (current == 'B') {
                vegetables.put("Black truffle", vegetables.get("Black truffle") + 1);
            } else if (current == 'S') {
                vegetables.put("Summer truffle", vegetables.get("Summer truffle") + 1);
            } else if (current == 'W') {
                vegetables.put("White truffle", vegetables.get("White truffle") + 1);
            }
            matrix[row][col] = '-';  // change
        }
    }

    private static boolean isValidIndexes(int row, int col) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }

    private static void readMatrix(Scanner scan, int n) {
        matrix = new char[n][];
        for (int row = 0; row < n; row++) {
            matrix[row] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static void printMatrix() {
        Arrays.stream(matrix).forEach(e -> System.out.println(Arrays.toString(e)
                .replaceAll("[\\[\\]]", "").replaceAll(", ", " ")));
    }
}
