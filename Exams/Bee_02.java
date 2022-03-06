package EXAMs;

import java.util.Scanner;

public class Bee_02 {

    public static int beeRow = 0;
    public static int beeCol = 0;
    public static int flowers = 0;
    public static boolean isOut = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                    matrix[row][col] = '.';
                }
            }
        }
        String directions = scanner.nextLine();
        while (!directions.equals("End") && isOut) {
            switch (directions) {
                case "up":
                    isOut = beeMove(matrix, -1, 0);
                    break;
                case "down":
                    isOut = beeMove(matrix, +1, 0);
                    break;
                case "left":
                    isOut = beeMove(matrix, 0, -1);
                    break;
                case "right":
                    isOut = beeMove(matrix, 0, +1);
                    break;
            }
            if (!isOut) {
                break;
            }
            directions = scanner.nextLine();
        }
        if (!isOut) {
            System.out.println("The bee got lost!");
        } else {
            matrix[beeRow][beeCol] = 'B';
        }
        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }
        printMatrix(matrix);
    }

    public static boolean beeMove(char[][] matrix, int newRow, int newCol) {
        if (outOfBounds(matrix, newRow + beeRow, newCol + beeCol)) {
            beeRow = beeRow + newRow;
            beeCol = beeCol + newCol;
            char current = matrix[beeRow][beeCol];
            if (current == 'f') {
                flowers++;
                matrix[beeRow][beeCol] = '.';
            } else if (current == 'O') {
                matrix[beeRow][beeCol] = '.';
                beeMove(matrix, newRow, newCol);
            } else {
                matrix[beeRow][beeCol] = '.';
            }
            return true;
        }
        return false;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char element : chars) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix.length;
    }
}
