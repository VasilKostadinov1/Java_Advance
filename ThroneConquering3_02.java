package EXAMs;

import java.util.Scanner;

public class ThroneConquering3_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Scanner s = new Scanner(System.in);
        int energy = Integer.parseInt(s.nextLine());
        int size = Integer.parseInt(s.nextLine());
        char[][] city = new char[size][size];

        fillCity(s, size, city);

        int parisRow = 0;
        int parisCol = 0;
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[i].length; j++) {
                if (city[i][j] == 'P') {
                    parisRow = i;
                    parisCol = j;

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

            city[parisRow][parisCol] = '-';
            city[spawnRol][spawnCol] = 'S';
            switch (direction) {
                case "up":
                    parisRow--;
                    break;
                case "down":
                    parisRow++;
                    break;
                case "left":
                    parisCol--;
                    break;
                case "right":
                    parisCol++;
                    break;
            }
            //  If Paris tries to move outside of the field, he doesn’t move
            if (parisRow < 0) {
                parisRow++;
            } else if (parisRow > size - 1) {
                parisRow--;
            } else if (parisCol > size - 1) {
                parisCol--;
            } else if (parisCol < 0) {
                parisCol++;
            }
            //Paris moves in a direction, which decreases his energy by 1.
            energy--;

            // If Paris’ energy drops at 0 or below, he dies and you should mark his position with ‘X’.
            if (energy <= 0) {
                city[parisRow][parisCol] = 'X';
                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                printMatrix(city);
                break;
            }
            //	If an enemy is on the same cell where Paris moves, Paris fights him, which decreases his energy by 2.
            if (city[parisRow][parisCol] == 'S') {
                energy -= 2;
                // If Paris’ energy drops at 0 or below, he dies and you should mark his position with ‘X’.
                if (energy <= 0) {
                    city[parisRow][parisCol] = 'X';
                    System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                    printMatrix(city);
                    break;
                } else {
                    city[parisRow][parisCol] = '-';
                }
            }// If Paris reaches the index where Helen is, they both run away (disappear from the field),
            // even if his energy is 0 or below.
            else if (city[parisRow][parisCol] == 'H') {
                city[parisRow][parisCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
                printMatrix(city);
                break;
            }
        }
    }

    private static void fillCity(Scanner s, int size, char[][] city) {
        for (int i = 0; i < size; i++) {
            city[i] = s.nextLine().toCharArray();
        }
    }

    private static void printMatrix(char[][] city) {
        for (char[] chars : city) {
            System.out.println(chars);
        }
    }
}
