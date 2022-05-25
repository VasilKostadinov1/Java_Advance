package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonal2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    // 10/100

        String[] rowColumn = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);
        int[][] matrix = getMatrix(scanner, row, col);

//        List<List<Integer>> reversDiagonal = new ArrayList<>();
//        for (int i = 0; i < row + col - 1; i++) {
//            reversDiagonal.add(new ArrayList<>());
//        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                reversDiagonal.get(row + col - 2 - (i + j)).add(0, matrix[i][j]);
//            }
//        }
        Arrays.stream(matrix).forEach(s -> {
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        });
    }

    private static int[][] getMatrix(Scanner scanner, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
