package EXAMs;

import java.util.Scanner;

public class Bomb3_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());          // by Petar Chulin
        String[] command = scanner.nextLine().split(",");
        char[][] field = new char[size][size];

        fillMatrix(scanner, size, field);
        int bombs = 0;
        int sapperRow = 0;
        int sapperCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 's') {
                    sapperRow = i;
                    sapperCol = j;
                }
                if (field[i][j] == 'B') {
                    bombs++;
                }
            }
        }
        System.out.println();  // check if input is correct
        int commands = command.length;
        for (String value : command) {
            field[sapperRow][sapperCol] = '+';  // sapper starts to the new position
            switch (value) {
                case "up":
                    sapperRow--;
                    break;
                case "down":
                    sapperRow++;
                    break;
                case "left":
                    sapperCol--;
                    break;
                case "right":
                    sapperCol++;
                    break;
            }
            // If the sapper reaches the side edge of the field (left, right,up or down),
            //it remains on his current position.
            if (sapperRow < 0) {
                sapperRow++;
            } else if (sapperRow > size - 1) {
                sapperRow--;
            } else if (sapperCol > size - 1) {
                sapperCol--;
            } else if (sapperCol < 0) {
                sapperCol++;
            }
            if (field[sapperRow][sapperCol] == 'B') {
                System.out.println("You found a bomb!");
                field[sapperRow][sapperCol] = '+';
                bombs--;
            }
            if (bombs == 0) {
                System.out.println("Congratulations! You found all bombs!");
                break;
            }
            if (field[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field", bombs);
                break;
            }
            field[sapperRow][sapperCol] = 's';   // sapper moves to the new position
            commands--;
        }
        if (commands == 0 && bombs > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, sapperRow, sapperCol);
        }
    }
    private static void fillMatrix(Scanner s, int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            String[] input = s.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                field[i][j] = input[j].charAt(0);
            }
        }
    }
}
