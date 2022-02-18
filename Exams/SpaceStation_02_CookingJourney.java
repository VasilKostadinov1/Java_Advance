package EXAMs;

import java.util.Scanner;

public class SpaceStation_02_CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = ReadMatrix(scanner, matrixSize);
        int playerRow = GetFirstRowSymbol('S', matrix);
        int playerCol = GetFirstColSymbol('S', playerRow, matrix);

        boolean isInVoid = false;
        int power = 0;
        while (power < 50) {
            String direction = scanner.nextLine();

            int currentPlayerRow = playerRow; // !!! make a copy and work with it (reference types)
            int currentPlayerCol = playerCol; // not changing the initials
            // no matter of the command, we'll have the supposed next position !!!

            switch (direction) {
                case "up":
                    currentPlayerRow -= 1;
                    break;
                case "down":
                    currentPlayerRow += 1;
                    break;
                case "left":
                    currentPlayerCol -= 1;
                    break;
                case "right":
                    currentPlayerCol += 1;
                    break;
            }
            // is in galaxy
            isInVoid = IsInSpace(currentPlayerRow, currentPlayerCol, matrix.length);
            if (isInVoid) {
                matrix[playerRow][playerCol] = '-';
                break;
            }
            char currentSymbol = matrix[currentPlayerRow][currentPlayerCol];
            if (currentSymbol == '-') {
                matrix[playerRow][playerCol] = '-';
                matrix[currentPlayerRow][currentPlayerCol] = 'S';
                playerRow = currentPlayerRow;
                playerCol = currentPlayerCol;
            } else if (Character.isDigit(currentSymbol)) {    // stars
                matrix[playerRow][playerCol] = '-';
                matrix[currentPlayerRow][currentPlayerCol] = 'S';
                playerRow = currentPlayerRow;
                playerCol = currentPlayerCol;

                power += currentSymbol - 48;
            } else if (currentSymbol == 'O') {    // black hole
                matrix[playerRow][playerCol] = '-';               // player = '-'
                matrix[currentPlayerRow][currentPlayerCol] = '-'; // 1st black hole = '-'

                // now find the coordinates of the black hole
                playerRow = GetFirstRowSymbol('O', matrix);
                playerCol = GetFirstColSymbol('O', playerRow, matrix);

                matrix[playerRow][playerCol] = 'S';
            }
        }
        if (isInVoid) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d", power);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char symbol : chars) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean IsInSpace(int playerRow, int playerCol, int length) {
        boolean isInSpace = playerRow < 0 || playerRow >= length || playerCol < 0 || playerCol >= length;
        return isInSpace;

    }

    private static int GetFirstColSymbol(char symbol, int row, char[][] matrix) {
        int index = -1;
        for (int col = 0; col < matrix.length; col++) {
            if (matrix[row][col] == symbol) {
                index = col;
                break;
            }
        }
        return index;
    }

    private static int GetFirstRowSymbol(char symbol, char[][] matrix) {
        int index = -1;
        int length = matrix.length;

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                if (matrix[row][col] == symbol) {
                    index = row;
                    break;
                }
            }
            if (index != -1) {
                break;
            }
        }
        return index;
    }

    private static char[][] ReadMatrix(Scanner scanner, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] colArr = scanner.nextLine().toCharArray(); // read a row (as string), convert to char
            matrix[row] = colArr;
        }
        return matrix;
    }
}
