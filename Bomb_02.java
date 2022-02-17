package EXAMs;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Bomb_02 {
    static char[][] matrix;
    static int currentRow;
    static int currentCol;
    static boolean isEnd = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        readMatrix(scanner, n);

        for (String command : commands) {
            switch (command) {
                case "up":
                    if (currentRow - 1 >= 0) {
                        currentRow--;
                        chekPosition();
                    }
                    break;
                case "down":
                    if (currentRow + 1 < matrix.length) {
                        currentRow++;
                        chekPosition();
                    }
                    break;
                case "left":
                    if (currentCol - 1 >= 0) {
                        currentCol--;
                        chekPosition();
                    }
                    break;
                case "right":
                    if (currentCol + 1 < matrix.length) {
                        currentCol++;
                        chekPosition();
                    }
                    break;
            }
            if (isEnd) {
                break;
            }
        }
        if (findBombs() == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isEnd) {
            System.out.printf("END! %d bombs left on the field", findBombs());
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", findBombs(), currentRow, currentCol);
        }


    }

    private static int findBombs() {
        int count = 0;
        for (char[] chars : matrix) {
            for (int i = 0; i < matrix.length; i++) {
                if (chars[i] == 'B') {
                    count++;
                }
            }
        }
        return count;
    }

    private static void chekPosition() {
        if (matrix[currentRow][currentCol] == 'B') {
            System.out.println("You found a bomb!");
            matrix[currentRow][currentCol] = '+';
        } else if (matrix[currentRow][currentCol] == 'e') {
            isEnd = true;
        }
    }

    private static void readMatrix(Scanner scan, int n) {

        matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String input = scan.nextLine().replaceAll("\\s+", "");
            matrix[row] = input.toCharArray();
            if (input.contains("s")) {
                currentRow = row;
                currentCol = input.indexOf('s');
            }
        }
    }
    /*private static void readMatrix(Scanner scanner, int n) {
        matrix = new char[n][n];
        IntStream.range(0, matrix.length).forEach(i -> {
            String input = scanner.nextLine();
            if (input.contains("s")) {
                currentRow = i;
                currentCol = input.indexOf('s');
            }
            matrix[i] = input.toCharArray();
        });
    }*/

}
