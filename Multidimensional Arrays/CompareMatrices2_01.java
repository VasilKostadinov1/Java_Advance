package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrixOne = result(scanner);    // Chulin
        int[][] matrixTwo = result(scanner);

        if (Arrays.deepEquals(matrixOne, matrixTwo)) {   // .deepEquals  !!!
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static int[][] result(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
