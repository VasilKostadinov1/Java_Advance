package EXAMs;

import java.util.Scanner;

public class Python2_02 {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner s = new Scanner(System.in);   // by Petar Chulin

        int size = Integer.parseInt(s.nextLine());
        String[] command = s.nextLine().split(", ");
        char[][] screen = new char[size][size];

        fillMatrix(s, size, screen);

        int pythonLength = 1;
        int food = 0;
        int pythonRow = 0;
        int pythonCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (screen[i][j] == 's') {
                    pythonRow = i;
                    pythonCol = j;
                }
                if (screen[i][j] == 'f') {
                    food++;
                }
            }
        }
        System.out.println();
        int commands = command.length;
        for (String value : command) {
            screen[pythonRow][pythonCol] = '*';
            switch (value) {
                case "up":
                    pythonRow--;
                    break;
                case "down":
                    pythonRow++;
                    break;
                case "left":
                    pythonCol--;
                    break;
                case "right":
                    pythonCol++;
                    break;
            }
            // If the python reaches the side edge of the screen (left or right), it goes to the opposite side of the same row.
            // If the python reaches the top/bottom edge of the screen it goes on the opposite side of the same column .
            if (pythonCol < 0) {
                pythonCol = size - 1;
            } else if (pythonCol > size - 1) {
                pythonCol = 0;
            }
            if (pythonRow < 0) {
                pythonRow = size - 1;
            } else if (pythonRow > size - 1) {
                pythonRow = 0;
            }
            // Each time you eat a piece of food your length increases by one
            if (screen[pythonRow][pythonCol] == 'f') {
                screen[pythonRow][pythonCol] = '*';
                pythonLength++;
                food--;
            }
            if (food == 0) {
                System.out.printf("You win! Final python length is %d", pythonLength);
                break;
            }
            if (screen[pythonRow][pythonCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                break;
            }
            screen[pythonRow][pythonCol] = 's';
            commands--;

        }
        if (commands == 0 && food > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }
    }

    private static void fillMatrix(Scanner s, int size, char[][] screen) {
        for (int i = 0; i < size; i++) {
            String[] input = s.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                screen[i][j] = input[j].charAt(0);
            }
        }
    }
}
