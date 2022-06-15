package EXAMs;

import java.util.Scanner;

public class TheBattleOfTheFiveArmies_CSharp_18Aug21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Scanner s = new Scanner(System.in);                // by Chulin and me !!!
        int energy = Integer.parseInt(s.nextLine());
        int size = Integer.parseInt(s.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(s, size, matrix);

        int armyRow = 0;
        int armyCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'A') {  // A  The Army, the player character
                    armyRow = i;
                    armyCol = j;
                }
            }
        }
        // System.out.println();   // check input
        while (true) {
            //up 3 0
            String[] tokens = s.nextLine().split(" ");
            String direction = tokens[0];
            int spawnRol = Integer.parseInt(tokens[1]);
            int spawnCol = Integer.parseInt(tokens[2]);

            matrix[armyRow][armyCol] = '-';    // Army starts moving
            matrix[spawnRol][spawnCol] = 'O';    // O - Orcs, enemy
            switch (direction) {
                case "up":
                    armyRow--;
                    break;
                case "down":
                    armyRow++;
                    break;
                case "left":
                    armyCol--;
                    break;
                case "right":
                    armyCol++;
                    break;
            }
            //  If Army tries to move outside of the field, he doesn’t move !!!
            if (armyRow < 0) {
                armyRow++;
            } else if (armyRow > size - 1) {
                armyRow--;
            } else if (armyCol > size - 1) {
                armyCol--;
            } else if (armyCol < 0) {
                armyCol++;
            }
            //Army moves in a direction, which decreases his energy by 1.
            energy--;

            // If Army’ energy drops at 0 or below, he dies and you should mark his position with ‘X’.
            if (energy <= 0) {
                matrix[armyRow][armyCol] = 'X';
                System.out.printf("The army was defeated at %d;%d.\n", armyRow, armyCol);
                printMatrix(matrix);  // in all cases, print the final state of the field on the console.
                break;
            }
            //	If an enemy is on the same cell where Paris moves, Paris fights him, which decreases his energy by 2.
            if (matrix[armyRow][armyCol] == 'O') {
                energy -= 2;
                // If Paris’ energy drops at 0 or below, he dies and you should mark his position with ‘X’.
                if (energy <= 0) {
                    matrix[armyRow][armyCol] = 'X';
                    System.out.printf("The army was defeated at %d;%d.\n", armyRow, armyCol);
                    printMatrix(matrix); // in all cases, print the final state of the field on the console.
                    break;
                } else {
                    matrix[armyRow][armyCol] = '-';
                }
            }// If Paris reaches the index where Helen is, they both run away (disappear from the field),
            // even if his energy is 0 or below.
            else if (matrix[armyRow][armyCol] == 'M') {
                matrix[armyRow][armyCol] = '-';           // Paris stops moving
                System.out.printf("The army managed to free the Middle World! Armor left: %d\n", energy);
                printMatrix(matrix);
                break;
            }

        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void fillMatrix(Scanner s, int size, char[][] matrix) {
        for (int i = 0; i < size; i++) {
            matrix[i] = s.nextLine().toCharArray();
        }
    }
}
