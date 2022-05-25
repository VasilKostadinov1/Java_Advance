package MultidimensionalArraysExercises;

import java.util.Scanner;

public class TheHeiganDance_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hsPoints = 3000000.0;
        int playerPoints = 18500;

        int startPlRow = 7;
        int startPlCol = 7;

        String lastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (playerPoints > 0 && hsPoints > 0) {
            hsPoints -= damage;

            if (activeCloud) {
                playerPoints -= 3500;
                activeCloud = false;

                if (playerPoints < 0) {
                    break;
                }
            }
            if (hsPoints < 0) {
                break;
            }
            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            boolean[][] matrix = new boolean[15][15];
            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < matrix.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < matrix[row].length) {
                            matrix[i][j] = true;
                        }
                    }
                }
            }
            //First, he tries to move up, if there’s damage/wall, he tries to move right, then down, then left.
            if (matrix[startPlRow][startPlCol]) {
                if (isRowValid(matrix, startPlRow - 1) && !matrix[startPlRow - 1][startPlCol]) {
                    startPlRow--; // move up
                } else if (isColValid(matrix, startPlCol + 1) && !matrix[startPlRow][startPlCol + 1]) {
                    startPlCol++; // move right
                } else if (isRowValid(matrix, startPlRow + 1) && !matrix[startPlRow + 1][startPlCol]) {
                    startPlRow++; // move down
                } else if (isColValid(matrix, startPlCol - 1) && !matrix[startPlRow][startPlCol - 1]) {
                    startPlCol--; // move left
                }

                if (matrix[startPlRow][startPlCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerPoints -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerPoints -= 6000;
                            lastSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if (hsPoints > 0) {
            System.out.printf("Heigan: %.2f%n", hsPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerPoints > 0) {
            System.out.printf("Player: %d%n", playerPoints);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + startPlRow + ", " + startPlCol);
    }

    private static boolean isColValid(boolean[][] matrix, int startCol) {
        return startCol >= 0 && startCol < matrix.length;
    }

    private static boolean isRowValid(boolean[][] matrix, int startRow) {
        return startRow >= 0 && startRow < matrix[startRow].length;
    }
}
