package EXAMs;

import java.util.Scanner;

public class TruffleHunter2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            matrix[row] = line;
        }

        String input;
        int black = 0;
        int summer = 0;
        int white = 0;
        int harmedVeg = 0;


        while (!"Stop the hunt".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (command.equals("Collect")) {
                if (!isOutOfBound(matrix, row, col)) {
                    String vegetable = matrix[row][col];
                    switch (vegetable) {
                        case "B":
                            black++;
                            break;
                        case "S":
                            summer++;
                            break;
                        case "W":
                            white++;
                            break;
                    }
                    matrix[row][col] = "-";    // change
                }
            } else {
                if (!isOutOfBound(matrix, row, col)) {
                    String direction = tokens[3];
                    switch (direction) {
                        case "up":
                            harmedVeg += moleVegetablesUp(matrix, row, col);
                            break;
                        case "down":
                            harmedVeg += moleVegetablesDown(matrix, row, col);
                            break;
                        case "left":
                            harmedVeg += moleVegetablesLeft(matrix, row, col);
                            break;
                        case "right":
                            harmedVeg += moleVegetablesRight(matrix, row, col);
                            break;
                    }
                }
            }
        }
        System.out.printf("Peter manages to harvest %d black, %d summer, and %d white truffles.%n",black, summer,white);
        System.out.printf("The wild boar has eaten %d truffles.%n", harmedVeg);
        printMatrix(matrix);

//        System.out.printf("Carrots: %d%nPotatoes: %d%nLettuce: %d%nHarmed vegetables: %d%n", black,
//                summer, white, harmedVeg);
    }
    private static int moleVegetablesUp(String[][] matrix, int row, int col) {
        int harmedVeg = 0;
        for (int i = row; row >= 0; ) {
            if (!isOutOfBound(matrix, row, col)) {
                if (!matrix[row][col].equals("-")) {   // change
                    matrix[row][col] = "-";            // change
                    harmedVeg++;
                }
            }
            row -= 2;
        }
        return harmedVeg;
    }

    public static int moleVegetablesDown(String[][] matrix, int row, int col) {
        int harmedVeg = 0;
        for (int i = row; row < matrix.length; ) {
            if (!isOutOfBound(matrix, row, col)) {
                if (!matrix[row][col].equals("-")) {   // change
                    matrix[row][col] = "-";            // change
                    harmedVeg++;
                }
            }
            row += 2;
        }
        return harmedVeg;
    }

    public static int moleVegetablesLeft(String[][] matrix, int row, int col) {
        int harmedVeg = 0;
        for (int i = col; col >= 0; ) {
            if (!isOutOfBound(matrix, row, col)) {
                if (!matrix[row][col].equals("-")) {
                    matrix[row][col] = "-";
                    harmedVeg++;
                }
            }
            col -= 2;
        }
        return harmedVeg;
    }

    public static int moleVegetablesRight(String[][] matrix, int row, int col) {
        int harmedVeg = 0;
        for (int i = col; col < matrix[row].length; ) {
            if (!isOutOfBound(matrix, row, col)) {
                if (!matrix[row][col].equals("-")) {
                    matrix[row][col] = "-";
                    harmedVeg++;
                }
            }
            col += 2;
        }
        return harmedVeg;
    }


    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");   // change
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBound(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
