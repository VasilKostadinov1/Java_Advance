package EXAMs;

import java.util.Scanner;

public class HelensAbduction_02 {

    public static int energy;    // done in order M. "moveParis" to have access to it

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[rows][];
        int parisRow = 0;
        int parisCol = 0;
        //int helenRow = 0;
        // int helenCol = 0;

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray(); // read a line and save on the line all characters
            if (line.contains("P")) {
                parisRow = i;
                parisCol = line.indexOf("P");
            }
        }

        boolean isAbducted = false;  // until he dies or reaches Helen
        while (energy > 0 && !isAbducted) {
            energy--;
            String direction = scanner.next();
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            field[row][col] = 'S';  // put the Spartan soldier
            field[parisRow][parisCol] = '-';  // we need to move the symbol as well !

            // now we have to move Paris
            if (direction.equals("up") && canMove(parisRow - 1, parisCol, field)) {
                parisRow--;
                isAbducted = moveParis(parisRow, parisCol, field);

            } else if (direction.equals("down") && canMove(parisRow + 1, parisCol, field)) {
                parisRow++;
                isAbducted = moveParis(parisRow, parisCol, field);

            } else if (direction.equals("left") && canMove(parisRow, parisCol - 1, field)) {
                parisCol--;
                isAbducted = moveParis(parisRow, parisCol, field);

            } else if (direction.equals("right") && canMove(parisRow, parisCol + 1, field)) {
                parisCol++;
                isAbducted = moveParis(parisRow, parisCol, field);
            }
            field[parisRow][parisCol] = 'P'; // we need to move the symbol as well !

        }
        if (isAbducted) {
            field[parisRow][parisCol] = '-';
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        } else {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d%n", parisRow, parisCol);
        }
        printField(field);
    }

    private static boolean moveParis(int newRow, int newCol, char[][] field) {
        boolean isAbducted = false;
        if (field[newRow][newCol] == 'S') {
            energy -= 2;
        } else if (field[newRow][newCol] == 'H') {
            isAbducted = true;
        }
        return isAbducted;
    }

    private static boolean canMove(int newRow, int newCol, char[][] field) { // shouldn't go out of the matrix!!!
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }

    private static void printField(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {  //take current row's length
                System.out.print(field[r][c]);
            }
            System.out.println();

        }
    }
}
