package EXAMs;

import java.util.Arrays;
import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = readMatrix(scanner, Integer.parseInt(scanner.nextLine()));
        int[] currentPosition = findIndexes(matrix, 'S');
        int countOfFood = 0;

        while (countOfFood < 10) {
            String input = scanner.nextLine();
            matrix[currentPosition[0]][currentPosition[1]] = '.';  //When the snake moves it leaves a trail marked
            switch (input) {
                case "up":
                    currentPosition[0]--;
                    break;
                case "down":
                    currentPosition[0]++;
                    break;
                case "left":
                    currentPosition[1]--;
                    break;
                case "right":
                    currentPosition[1]++;
                    break;
            }
            if (indexIsInBounds(currentPosition, matrix)) {
                if (matrix[currentPosition[0]][currentPosition[1]] == '*') {
                    countOfFood++;
                    matrix[currentPosition[0]][currentPosition[1]] = 'S';
                } else if (matrix[currentPosition[0]][currentPosition[1]] == 'B') {
                    matrix[currentPosition[0]][currentPosition[1]] = '.';
                    currentPosition = findIndexes(matrix, 'B');
                }
            } else {
                break;
            }
        }
        if (countOfFood < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + countOfFood);

        printMatrix(matrix);


    }

    private static int[] findIndexes(char[][] matrix, char toFind) {
        int[] indexes = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == toFind) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }
        return indexes;
    }

    private static boolean indexIsInBounds(int[] currentPosition, char[][] matrix) {
        return currentPosition[0] >= 0 && currentPosition[0] < matrix.length
                && currentPosition[1] >= 0 && currentPosition[1] < matrix.length;
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }

    private static char[][] readMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
