package EXAMs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BeaverAtWork_CSharp_20Feb22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[size][size];

        for (int i = 0; i < size; i++) {        // fill the matrix
            territory[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        int beeRow = 0;
        int beeCol = 0;
        int fish = 0;
        int wood = 0;
        List<Character> charsForPrint = new ArrayList<>();
        for (int i = 0; i < size; i++) {   // find where is the Bee
            for (int j = 0; j < size; j++) {
                if (territory[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
                if (territory[i][j] == 'F') {
                    fish++;
                }
                if (territory[i][j] >= 97 && territory[i][j] <= 122) {
                    charsForPrint.add(territory[i][j]);
                    wood++;
                }
            }
        }
        //System.out.println();  // check input data in Debug !
        int pollinated = 0;
        boolean isWoodZero = false;
        while (true) {
            //The commands will be: "up", "down", "left", "right", "End".
            String direction = scanner.nextLine();
            if (direction.equals("end")) {
                break;
            }
            //Anytime the beaver moves, change the value of the cell of his new position to 'B' and the cell it left to '-' (dash).
            territory[beeRow][beeCol] = '-'; // Bee moves to a direction
            switch (direction) {             // current coordinates become '-'
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
            //boolean isFish = territory[beeRow][beeCol] == 'F';
            //char isChar = territory[beeRow][beeCol];
            //boolean isWood = territory[beeRow][beeCol]==Character.toLowerCase(isChar) ;

            //•	If the beaver moves outside of the pond (field), he drops his last collected wood branch (if there are any),
            // without changing its current position.
            if (beeRow < 0) {
                beeRow++;
                wood = isSmallLetter(territory, beeRow, beeCol, wood);
            } else if (beeRow > size - 1) {
                beeRow--;
                wood = isSmallLetter(territory, beeRow, beeCol, wood);
            } else if (beeCol > size - 1) {
                beeCol--;
                wood = isSmallLetter(territory, beeRow, beeCol, wood);
            } else if (beeCol < 0) {
                beeCol++;
                wood = isSmallLetter(territory, beeRow, beeCol, wood);
            }

            //	If the beaver moves to a wood branch it puts it away for his new home.
            wood = isSmallLetter(territory, beeRow, beeCol, wood);

            // If it goes to a bonus, the bee gets a bonus one move forward
            // There will always be only one bonus. It will be marked with the letter - 'O'
            if (territory[beeRow][beeCol] == 'F') {
                territory[beeRow][beeCol] = '-';
                fish--;
                //If the braver eats a fish on the last index – it swims in the opposite direction. Opposite of "up" is "down",
                // opposite of "left" is "right
                if (beeCol == 0) {
                    beeCol = size - 1;
                } else if (beeCol == size - 1) {
                    beeCol = 0;
                }
                if (beeRow == 0) {
                    beeRow = size - 1;
                } else if (beeRow == size - 1) {
                    beeRow = 0;
                }
            }
            territory[beeRow][beeCol] = 'B';    // Bee has moved to the new point
            if (wood == 0) {
                isWoodZero = true;
                break;
            }
        }

        if (isWoodZero) {
            System.out.printf("The Beaver successfully collect %d wood branches: %s%n",
                    charsForPrint.size(),charsForPrint.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.printf("The Beaver failed to collect every wood branch. There are %d branches left.%n", wood);
        }
        printMatrix(territory);

    }

    private static int isSmallLetter(char[][] territory, int beeRow, int beeCol, int wood) {
        if (territory[beeRow][beeCol] >= 97 && territory[beeRow][beeCol] <= 122) {
            wood--;
        }
        return wood;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
