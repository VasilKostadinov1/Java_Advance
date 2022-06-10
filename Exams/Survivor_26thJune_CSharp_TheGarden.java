package EXAMs;

import java.util.Scanner;

public class Survivor_26thJune_CSharp_TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());  // only 2nd output is working

        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            matrix[row] = line;
        }

        String input;
        int collectTokens = 0;
        int potatoes = 0;
        int lettuce = 0;
        int opponentTokens = 0;

        while (!"Gong".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (command.equals("Find")) {
                if (!isOutOfBound(matrix, row, col)) {
                    String vegetable = matrix[row][col];
                    switch (vegetable) {
                        case "C":
                            collectTokens++;
                            break;
//                        case "P":
//                            potatoes++;
//                            break;
//                        case "L":
//                            lettuce++;
//                            break;
                    }
                    matrix[row][col] = "-";
                }
            } else {
                if (!isOutOfBound(matrix, row, col)) {
                    String direction = tokens[3];
                    switch (direction) {
                        case "up":
                            opponentTokens += moleVegetablesUp(matrix, row, col);
                            break;
                        case "down":
                            opponentTokens += moleVegetablesDown(matrix, row, col);
                            break;
                        case "left":
                            opponentTokens += moleVegetablesLeft(matrix, row, col);
                            break;
                        case "right":
                            opponentTokens += moleVegetablesRight(matrix, row, col);
                            break;
                    }
                }
            }
        }
        printMatrix(matrix);

        System.out.printf("Collected tokens: %d%nOpponent's tokens: %d%n", collectTokens,
                 opponentTokens);
    }
    private static int moleVegetablesUp(String[][] matrix, int row, int col) {
        int harmedVeg = 0;
        for (int i = row; row >= 0; ) {
            if (!isOutOfBound(matrix, row, col)) {
                if (!matrix[row][col].equals("-")) {
                    matrix[row][col] = "-";
                    harmedVeg++;
                }
            }
            row -= 2;
        }
        return harmedVeg;
    }

    public static int moleVegetablesDown(String[][] matrix, int row, int col) {
        int harmedVeg = 0;
        for (int i = row; row < matrix.length; ) {
            if (!isOutOfBound(matrix, row, col)) {
                if (!matrix[row][col].equals("-")) {
                    matrix[row][col] = "-";
                    harmedVeg++;
                }
            }
            row += 2;
        }
        return harmedVeg;
    }

    public static int moleVegetablesLeft(String[][] matrix, int row, int col) {
        int harmedVeg = 0;
        for (int i = col; col >= 0; ) {
            if (!isOutOfBound(matrix, row, col)) {
                if (!matrix[row][col].equals("-")) {
                    matrix[row][col] = "-";
                    harmedVeg++;
                }
            }
            col -= 2;
        }
        return harmedVeg;
    }

    public static int moleVegetablesRight(String[][] matrix, int row, int col) {
        int harmedVeg = 0;
        for (int i = col; col < matrix[row].length; ) {
            if (!isOutOfBound(matrix, row, col)) {
                if (!matrix[row][col].equals("-")) {
                    matrix[row][col] = "-";
                    harmedVeg++;
                }
            }
            col += 2;
        }
        return harmedVeg;
    }


    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBound(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
