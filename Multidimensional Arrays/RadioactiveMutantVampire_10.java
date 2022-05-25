package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampire_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimension[0];
        int columns = dimension[1];

        String [][] matrix = new String[rows][columns];
        boolean [][] bunniesIndexes = new boolean[rows][columns];

        int [] playerIndexes = new int[2];

        for (int r = 0; r < rows; r++) {
            String [] currentRow = scanner.nextLine().split("");
            matrix[r] = currentRow;
            for (int c = 0; c < columns; c++) {
                if (matrix[r][c].equals("P")) {
                    playerIndexes[0] = r;
                    playerIndexes[1] = c;
                }
                else if (matrix[r][c].equals("B")){
                    bunniesIndexes[r][c] = true;
                }
            }
        }
        String [] playerDirections = scanner.nextLine().split("");

        for (String direction : playerDirections) {
            int currentRow = playerIndexes[0];
            int currentCol = playerIndexes[1];

            switch (direction) {
                case "U":
                    currentRow--;
                    break;
                case "D":
                    currentRow++;
                    break;
                case "R":
                    currentCol++;
                    break;
                case "L":
                    currentCol--;
                    break;
            }
            if (isInBounds(matrix, currentRow, currentCol)) {
                if (!bunniesIndexes[currentRow][currentCol]) {
                    matrix[playerIndexes[0]][playerIndexes[1]] = ".";
                    playerIndexes[0] = currentRow;
                    playerIndexes[1] = currentCol;
                    matrix[playerIndexes[0]][playerIndexes[1]] = "P";
                    matrix = multipleBunnies(matrix, bunniesIndexes);
                    if (bunniesIndexes[playerIndexes[0]][playerIndexes[1]]) {
                        printMatrix(matrix);
                        System.out.println(String.format("dead: %d %d", playerIndexes[0], playerIndexes[1]));
                        return;
                    }
                } else {
                    matrix = multipleBunnies(matrix, bunniesIndexes);
                    printMatrix(matrix);
                    System.out.println(String.format("dead: %d %d", currentRow, currentCol));
                    return;
                }
            } else  {
                matrix = multipleBunnies(matrix, bunniesIndexes);
                if (matrix[playerIndexes[0]][playerIndexes[1]].equals("P")) {
                    matrix[playerIndexes[0]][playerIndexes[1]] = ".";
                }
                printMatrix(matrix);
                System.out.printf("won: %d %d%n", playerIndexes[0], playerIndexes[1]);
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static String[][] multipleBunnies(String[][] matrix, boolean[][] bunniesIndexes) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (bunniesIndexes[r][c]) {
                    if (isInBounds(matrix, r - 1, c)) {
                        matrix[r - 1][c] = "B";
                    }
                    if (isInBounds(matrix, r + 1, c)) {
                        matrix[r + 1][c] = "B";
                    }
                    if (isInBounds(matrix, r, c + 1)){
                        matrix[r][c + 1] = "B";
                    }
                    if (isInBounds(matrix, r, c - 1)){
                        matrix[r][c - 1] = "B";
                    }
                }
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("B")){
                    bunniesIndexes[r][c] = true;
                }
            }
        }
        return matrix;
    }

    private static boolean isInBounds(String[][] matrix, int row, int column) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length;
    }
}
