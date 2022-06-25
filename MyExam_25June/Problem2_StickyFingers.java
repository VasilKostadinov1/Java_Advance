package Exam_25June_2022;

import java.util.Scanner;

public class Problem2_StickyFingers {

    private static int pocketTotal = 0;
    private static boolean gotCaught = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split(",");   // ", "  in Python !!!!
        char[][] matrix = new char[size][size];

        fillMatrix(scanner, size, matrix);   // + + + B +

        int houses = 0;
        int sapperRow = 0;
        int sapperCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'D') {   // find Sapper coordinates
                    sapperRow = i;
                    sapperCol = j;
                }
                if (matrix[i][j] == '$') {   // Keep track of the count of the bombs.
                    houses++;
                }
            }
        }
        // System.out.println();     // check if input is correct
        int commands = command.length;           // find the number of commands = 5
        for (String value : command) {           // iterate over all commands
            matrix[sapperRow][sapperCol] = '+';  // sapper starts to the new position
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
            // If the sapper reaches the side edge of the matrix (left, right,up or down),
            //it remains on his current position.
            if (sapperRow < 0) {
                sapperRow++;
                System.out.println("You cannot leave the town, there is police outside!");
            } else if (sapperRow > size - 1) {
                sapperRow--;
                System.out.println("You cannot leave the town, there is police outside!");
            } else if (sapperCol > size - 1) {
                sapperCol--;
                System.out.println("You cannot leave the town, there is police outside!");
            } else if (sapperCol < 0) {
                sapperCol++;
                System.out.println("You cannot leave the town, there is police outside!");
            }
            //When Dillinger robs a house replace "$" with "+", calculate how much he has stolen by multiplying row and column indexes
            // of the found symbol "$", add the money to his pocket and print
            if (matrix[sapperRow][sapperCol] == '$') {
                int money = sapperRow * sapperCol;
                pocketTotal += money;
                matrix[sapperRow][sapperCol] = '+';
                System.out.printf("You successfully stole %d$.%n", money);
                //houses--;
            }

            //	When he steps on "P", he gets caught, print on the console
            if (matrix[sapperRow][sapperCol] == 'P') {
                gotCaught = true;
                matrix[sapperRow][sapperCol] = '#';
                break;
            }
            matrix[sapperRow][sapperCol] = 'D';   // sapper moves to the new position
            commands--;
        }
        //	If there are no more commands and none of the above cases happens
//        if (commands == 0 && houses > 0 ) {   // && !isDead
//            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.");
//        }

        if (!gotCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", pocketTotal);
        } else {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", pocketTotal);
        }

        printMatrixWithSpace(matrix);    // with space
    }
    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {   // Martin, Desi
        for (char row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

    }

    private static void printMatrixWithSpace(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
