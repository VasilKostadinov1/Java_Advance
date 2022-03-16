package EXAMs;

import java.util.Scanner;

public class ReVolt2_02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        int commands = Integer.parseInt(s.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = s.nextLine().toCharArray();

        }
        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'f') {
                    playerRow = i;
                    playerCol = j;
                }
            }

        }
        while (commands != 0) {

            String direction = s.nextLine();
            matrix[playerRow][playerCol] = '-';
            switch (direction) {
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

            if (matrix[playerRow][playerCol] == 'B' || matrix[playerRow][playerCol] == 'T') {
                switch (direction) {
                    case "up":
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerRow--;
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerRow++;
                        }
                        break;
                    case "down":
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerRow++;
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerRow--;
                        }
                        break;
                    case "left":
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerCol--;
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerCol++;
                        }
                        break;
                    case "right":
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerCol++;
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerCol--;
                        }
                        break;
                }
            }
            playerCol = checkBounds(n, playerCol);
            playerRow = checkBounds(n, playerRow);

            if (matrix[playerRow][playerCol] == 'F') {
                matrix[playerRow][playerCol] = 'f';
                System.out.println("Player won!");
                break;
            }
            matrix[playerRow][playerCol] = 'f';
            commands--;
            if (commands == 0) {
                System.out.println("Player lost!");
            }
        }
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static int checkBounds(int n, int playerCol) {
        if (playerCol < 0) {
            playerCol = n - 1;
        } else if (playerCol > n - 1) {
            playerCol = 0;
        }
        return playerCol;
    }
}
