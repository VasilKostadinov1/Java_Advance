package EXAMs;

import java.util.Arrays;
import java.util.Scanner;



public class ReVolt_02 {

    static char[][] matrix;
    static int[] currentPosition = new int[2];
    static boolean isFinished=false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        readMatrix(scanner, sizeMatrix);

        while (countCommands-- > 0 && !isFinished) {
            matrix[currentPosition[0]][currentPosition[1]] = '-';  // all the empty slots will be filled with "-"
            int[] previousPosition = new int[]{currentPosition[0],currentPosition[1]};
            String command = scanner.nextLine();
            checkMove(command);
            checkPosition(command,previousPosition);
        }

        System.out.println(isFinished ? "Player won!" : "Player lost!");
        printMatrix(matrix);
    }

    private static void checkPosition(String command, int[] previousPosition) {
        if (matrix[currentPosition[0]][currentPosition[1]] == 'F') {
            matrix[currentPosition[0]][currentPosition[1]] = 'f';
            isFinished = true;
        } else if (matrix[currentPosition[0]][currentPosition[1]] == 'B') { //  If the player steps on a bonus,
            checkMove(command);                                             // he should move another step forward in the direction he is going
            checkPosition(command,previousPosition);
        } else if (matrix[currentPosition[0]][currentPosition[1]] == 'T') { // If the player steps on a trap, he should move a step backwards.
            currentPosition[0] = previousPosition[0];
            currentPosition[1] = previousPosition[1];
            matrix[currentPosition[0]][currentPosition[1]] = 'f';
        } else {
            matrix[currentPosition[0]][currentPosition[1]] = 'f';
        }
    }

    private static void checkMove(String command) {
        if ("up".equals(command)) {
            currentPosition[0]--;
            if (currentPosition[0] < 0) {                  //If the player goes out of the matrix, he comes in from the other side
                currentPosition[0] = matrix.length - 1;
            }
        } else if ("down".equals(command)) {
            currentPosition[0]++;
            if (currentPosition[0] > matrix.length - 1) {  //If the player goes out of the matrix, he comes in from the other side
                currentPosition[0] = 0;
            }
        } else if ("left".equals(command)) {
            currentPosition[1]--;
            if (currentPosition[1] < 0) {
                currentPosition[1] = matrix.length - 1;
            }
        } else if ("right".equals(command)) {
            currentPosition[1]++;
            if (currentPosition[1] > matrix.length - 1) {
                currentPosition[1] = 0;
            }
        }
    }

    private static void readMatrix(Scanner scanner, int size) {
        matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            matrix[row] = input.replaceAll("\\s+", "").toCharArray();
            if (input.contains("f")) {       // !!! needed in order to remove symbol "f". once moved to next position
                currentPosition[0] = row;
                currentPosition[1] = input.indexOf('f');
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }
}
