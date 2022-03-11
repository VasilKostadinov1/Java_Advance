package EXAMs;

import java.util.Scanner;

public class FormulaOne2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // by Petar Chulin
        int n = Integer.parseInt(scanner.nextLine());
        int turns = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        fillMatrix(scanner, n, matrix);

        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < n; i++) {         // find player coordinates
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        // System.out.println(); -> check if input is ok, both matrix and player coordinates

        while (turns-- > 0) {

            String input = scanner.nextLine();
            matrix[playerRow][playerCol] = '.';
            switch (input) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            playerCol = checkBounds(n, playerCol);
            playerRow = checkBounds(n, playerRow);

            // If the player steps on a bonus, he should move another step forward
            if (matrix[playerRow][playerCol] == 'B') {
                switch (input) {
                    case "up":
                        playerRow--;
                        break;
                    case "down":
                        playerRow++;
                        break;
                    case "left":
                        playerCol--;
                        break;
                    case "right":
                        playerCol++;
                        break;
                }
            } // If the player steps on a trap, he should move a step backwards.
            else if (matrix[playerRow][playerCol] == 'T') {
                switch (input) {
                    case "up":
                        playerRow++;
                        break;
                    case "down":
                        playerRow--;
                        break;
                    case "left":
                        playerCol++;
                        break;
                    case "right":
                        playerCol--;
                        break;
                }
            }

            playerCol = checkBounds(n, playerCol);
            playerRow = checkBounds(n, playerRow);

            //	When the final matrix is printed and the vehicle has completed successfully, you must replace the "F" with the "P".
            if (matrix[playerRow][playerCol] == 'F') {
                matrix[playerRow][playerCol] = 'P';
                System.out.println("Well done, the player won first place!");
                break;
            }
            matrix[playerRow][playerCol] = 'P';
            if (turns == 0) {
                System.out.println("Oh no, the player got lost on the track!");
            }
        }
        printMatrix(matrix);
    }
    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }


    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int i = 0; i < n; i++) {
//            String line = scanner.nextLine();
//            char[] symbol = line.toCharArray();
//            matrix[i] = symbol;
            matrix[i] =scanner.nextLine().toCharArray();
        }
    }

    //If the player goes out of the matrix, he comes in from the other side.
    private static int checkBounds(int n, int playerCol) {
        if (playerCol < 0) {
            playerCol = n - 1;
        } else if (playerCol > n - 1) {
            playerCol = 0;
        }
        return playerCol;
    }
}
