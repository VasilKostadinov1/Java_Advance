package EXAMs;

import java.util.Scanner;

public class Bee2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // by Petar Chulin

        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[size][size];

        for (int i = 0; i < size; i++) {
            territory[i] = scanner.nextLine().toCharArray();
        }
        int beeRow = 0;
        int beeCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (territory[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }
        // System.out.println();  // check input data in Debug !
        int pollinated = 0;
        while (true) {
            String direction = scanner.nextLine();
            if (direction.equals("End")) {
                break;
            }
            territory[beeRow][beeCol] = '.'; // Bee moves to a direction
            switch (direction) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }
            // If the bee goes out she can't return back and the program ends. Print:
            if (beeRow < 0 || beeRow > size - 1 || beeCol < 0 || beeCol > size - 1) {
                System.out.println("The bee got lost!");
                break;
            }
            // If it goes to a bonus, the bee gets a bonus one move forward
            // There will always be only one bonus. It will be marked with the letter - 'O'
            if (territory[beeRow][beeCol] == 'O') {
                territory[beeRow][beeCol] = '.';
                switch (direction) {
                    case "up":
                        beeRow--;
                        break;
                    case "down":
                        beeRow++;
                        break;
                    case "left":
                        beeCol--;
                        break;
                    case "right":
                        beeCol++;
                        break;
                }
            }
            if (territory[beeRow][beeCol] == 'f') {
                pollinated++;
                territory[beeRow][beeCol] = '.';
            }
            territory[beeRow][beeCol] = 'B';    // Bee has moved to the new point
        }
        if (pollinated >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n" , pollinated);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n" , 5 - pollinated);
        }
        for (char[] chars : territory) {
            System.out.println(chars);
        }


    }
}
