package EXAMs;

import java.util.Scanner;

public class MouseAndCheese_02 {

    static int mouseRow = 0;
    static int mouseCol = 0;
    static boolean isOut = true;
    static int cheese = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                    matrix[row][col] = '-';
                }
            }
        }
        String directions = scanner.nextLine();
        while (!directions.equals("end") && isOut) {
            switch (directions) {
                case "up":
                    isOut = mouseMove(matrix, -1, 0);
                    break;
                case "down":
                    isOut = mouseMove(matrix, +1, 0);
                    break;
                case "left":
                    isOut = mouseMove(matrix, 0, -1);
                    break;
                case "right":
                    isOut = mouseMove(matrix, 0, +1);
                    break;
            }
            if (!isOut) {
                break;
            }
            directions = scanner.nextLine();
        }
        if (!isOut) {
            System.out.println("Where is the mouse?");
        } else {
            matrix[mouseRow][mouseCol] = 'M';
        }
        if (cheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        } else {
            System.out.println("Great job, the mouse is fed " + cheese + " cheeses!");
        }
        printMatrix(matrix);

    }
    public static boolean mouseMove(char[][] matrix, int newRow, int newCol) {
        if (outOfBounds(matrix, newRow + mouseRow, newCol + mouseCol)) {
            mouseRow = mouseRow + newRow;
            mouseCol = mouseCol + newCol;
            char current = matrix[mouseRow][mouseCol];
            if (current == 'c') {
                cheese++;
                matrix[mouseRow][mouseCol] = '-';
            } else if (current == 'B') {
                matrix[mouseRow][mouseCol] = '-';
                mouseMove(matrix, newRow, newCol);
            } else {
                matrix[mouseRow][mouseCol] = '-';
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
