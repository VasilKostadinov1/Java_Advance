package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());   // Martin P.

        int[][] matrix = new int[size][size];

        //fill matrix
        for (int r = 0; r < size; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        //System.out.println();

        for (int index = 0; index < size; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();
        // while I am in the matrix...
        int row = size-1;
        int col = 0;

        /*while (row >= 0 && row < size && col >= 0 && col < size){
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }*/
        while (isInBounds(row,col,matrix)){
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    private static boolean isOutBounds(int row, int col, int[][] matrix) {
        return !isInBounds(row, col, matrix);
    }
}
