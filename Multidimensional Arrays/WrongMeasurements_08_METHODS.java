package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements_08_METHODS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(rows, 0, scanner, "\\s+");

        int[] coordinates = readArray(scanner.nextLine(), "\\s+");

        int wrongValue = matrix[coordinates[0]][coordinates[1]];

        List<int[]> updatedValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    updatedValues.add(new int[]{row, col, getClosestItemsSum(row, col, matrix, wrongValue)});
                }
            }
        }
        for (int[] updatedValue : updatedValues) {
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
        }
        printMatrix(matrix);

    }

    private static int getClosestItemsSum(int row, int col, int[][] matrix, int wrongValue) {
        // Най - близките елементи в матрицата -> сумата
        int sum = 0;

        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        return sum;
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        //дали е в матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(int[][] matrix) {
        //принтиране на матрица от int
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        // прочитане на матрица
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }
        return matrix;
    }
    public static void printMatrixChars(char[][] matrix) {
        //принтиране на матрица от Char
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
