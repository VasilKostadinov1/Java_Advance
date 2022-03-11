package EXAMs;

import java.util.Scanner;

public class MouseAndCheese2_02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //by Petar Chulin

        int size = Integer.parseInt(s.nextLine());
        char[][] territory = new char[size][size];

        fillMatrix(s, size, territory);

        int cheese = 0;
        int mouseRow = 0;
        int mouseCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (territory[i][j] == 'M') {
                    mouseRow = i;
                    mouseCol = j;
                    break;
                }
            }
        }
        String commands = s.nextLine();
        while (!commands.equals("end")) {

            territory[mouseRow][mouseCol] = '-';
            switch (commands) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }

            if (mouseRow < 0 || mouseRow >= size || mouseCol < 0 || mouseCol >= size) {
                System.out.println("Where is the mouse?");
                break;
            }
            if (territory[mouseRow][mouseCol] == 'c') {
                territory[mouseRow][mouseCol] = '-';
                cheese++;
            }
            if (territory[mouseRow][mouseCol] == 'B') {
                continue;
            }
            territory[mouseRow][mouseCol] = 'M';
            commands = s.nextLine();
        }
        if (cheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - cheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheese);
        }
        printMatrix(territory);

    }
    private static void printMatrix(char[][] territory) {
        for (char[] chars : territory) {
            System.out.println(chars);
        }
    }

    private static void fillMatrix(Scanner s, int size, char[][] territory) {
        for (int i = 0; i < size; i++) {
            territory[i] = s.nextLine().toCharArray();
        }
    }
}
