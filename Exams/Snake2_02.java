package EXAMs;

import java.util.Scanner;

public class Snake2_02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int size = Integer.parseInt(s.nextLine());
        char[][] field = new char[size][size];
        int food = 0;

        for (int i = 0; i < size; i++) {
            field[i] = s.nextLine().toCharArray();
        }
        int snakeRow = 0;
        int snakeCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }
        // System.out.println();   // check input data
        while (true) {
            String direction = s.nextLine();
            // When the snake moves it leaves a trail marked with '.'
            field[snakeRow][snakeCol] = '.';
            switch (direction) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }
            // If the snake goes out of its territory, the game is over.
            if (snakeRow < 0 || snakeRow > size - 1 || snakeCol < 0 || snakeCol > size - 1) {
                System.out.println("Game over!");
                break;
            }
            // food on random positions, marked with '*'.
            if (field[snakeRow][snakeCol] == '*') {
                field[snakeRow][snakeCol] = '.';
                food++;
            }
            // two burrows marked with the letter - 'B'
            //If it goes inside to a burrow, it goes out on the position of the other burrow and then both burrows disappear.
            if (field[snakeRow][snakeCol] == 'B') {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        while (field[i][j] == 'B') {
                            field[i][j] = '.';
                            snakeRow = i;
                            snakeCol = j;
                        }
                    }
                }
            }
            field[snakeRow][snakeCol] = 'S';
            // The snake needs at least 10 food quantity to be fed.
            if (food >= 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
        }
        System.out.printf("Food eaten: %d\n" , food);
        for (char[] chars : field) {
            System.out.println(chars);
        }
    }
}
