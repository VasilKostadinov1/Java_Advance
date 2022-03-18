package EXAMs;

import java.util.Scanner;

public class PresentDelivery_02_CSharp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int presents = Integer.parseInt(s.nextLine());
        int size = Integer.parseInt(s.nextLine());
        char[][] neighborhood = new char[size][size];

        int niceKids = 0;
        int giftedKids = 0;

        chekNeighborhood(s, size, neighborhood);
        niceKids = getNiceKids(size, neighborhood, niceKids);

        int countOfNiceKid = niceKids;

        int santasRow = 0;
        int santasCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (neighborhood[i][j] == 'S') {
                    santasRow = i;
                    santasCol = j;
                    break;
                }
            }
        }
        System.out.println();
        while (true) {
            String command = s.nextLine();
            if (command.equals("Christmas morning")) {
                break;
            }
            neighborhood[santasRow][santasCol] = '-';
            switch (command) {
                case "up":
                    santasRow--;
                    break;
                case "down":
                    santasRow++;
                    break;
                case "left":
                    santasCol--;
                    break;
                case "right":
                    santasCol++;
                    break;
            }
            if (santasRow < 0 || santasRow > size - 1 || santasCol < 0 || santasCol > size - 1) {
                break;
            }
            // If he moves to a house with a nice kid, the kid receives a present
            if (neighborhood[santasRow][santasCol] == 'V') {
                neighborhood[santasRow][santasCol] = '-';
                presents--;
                giftedKids++;
                niceKids--;
                // but if Santa reaches a house with a naughty kid, he doesn’t drop a present.
            } else if (neighborhood[santasRow][santasCol] == 'X') {
                neighborhood[santasRow][santasCol] = '-';

            }// If the command sends Santa to a cell marked with 'C', Santa eats cookies and becomes happy and extra generous so
             // all the kids around him* receive presents (doesn’t matter if naughty or nice).
             // *around him means on his left, right, upwards and downwards by one cell
            else if (neighborhood[santasRow][santasCol] == 'C') {

                char[] cells = new char[4];
                char up = neighborhood[santasRow - 1][santasCol];
                char down = neighborhood[santasRow + 1][santasCol];
                char left = neighborhood[santasRow][santasCol - 1];
                char right = neighborhood[santasRow][santasCol + 1];


                cells[0] = up;
                cells[1] = down;
                cells[2] = left;
                cells[3] = right;

                for (char cell : cells) {
                    if ((cell == 'V') || (cell == 'X')) {
                        if (cell == 'V') {
                            niceKids--;
                        }
                        giftedKids++;
                        presents--;

                        if (presents <= 0) {
                            break;
                        }
                    }
                }
                neighborhood[santasRow - 1][santasCol] = '-';
                neighborhood[santasRow + 1][santasCol] = '-';
                neighborhood[santasRow][santasCol - 1] = '-';
                neighborhood[santasRow][santasCol + 1] = '-';
            }
            neighborhood[santasRow][santasCol] = 'S';

            // If Santa runs out of presents or you receive the command "Christmas morning", then you have to end
            if (presents == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }
        }
        for (char[] chars : neighborhood) {
            for (char a : chars) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        if (niceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", giftedKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", countOfNiceKid - giftedKids);
        }
    }

    private static int getNiceKids(int size, char[][] neighborhood, int niceKids) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (neighborhood[i][j] == 'V') {
                    niceKids++;
                }
            }
        }
        return niceKids;
    }

    private static void chekNeighborhood(Scanner s, int size, char[][] neighborhood) {
        for (int i = 0; i < size; i++) {
            String[] input = s.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                neighborhood[i][j] = input[j].charAt(0);
            }
        }
    }


}
