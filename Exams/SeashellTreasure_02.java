package EXAMs;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SeashellTreasure_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);     // by Lyubo Tomanov

        int n = Integer.parseInt(scanner.nextLine());
        int stolenShells = 0;
        List<String> collectedShells = new LinkedList<>();

        String[][] beach = new String[n][];       // Jagged !!!
        for (int i = 0; i < beach.length; i++) {
            beach[i] = scanner.nextLine().split("\\s+"); // now check if Matrix is printed correctly
        }
        String input = scanner.nextLine();
        while (!input.equals("Sunset")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Collect":
                    if (isValidIndex(row, col, beach)) {
                        String shell = beach[row][col];
                        if (!shell.equals("-")) {
                            collectedShells.add(shell);
                            beach[row][col] = "-";
                        }
                    }
                    break;
                case "Steal":
                    String direction = tokens[3];
                    if (isValidIndex(row, col, beach)) {
                        String shell = beach[row][col];
                        if (!shell.equals("-")) {
                            stolenShells++;
                            beach[row][col] = "-";
                        }
                        stolenShells += stealing(beach, row, col, direction);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printMatrix(beach);
        System.out.printf("Collected seashells: %d",collectedShells.size());
        if (!collectedShells.isEmpty()){
            System.out.print(" -> ");
            System.out.println(String.join(", ", collectedShells));
        }else {
            System.out.println();
        }
        System.out.println(String.format("Stolen seashells: %d",stolenShells));

    }

    private static int stealing(String[][] beach, int row, int col, String direction) {
        int counter = 0;
        switch (direction) {
            case "up":       // if we go up, rows decrease
                for (int i = row; i >= row - 3; i--) {
                    counter = getCounter(beach, col, counter, i);
                }
                break;
            case "down":
                for (int i = row; i <= row + 3; i++) {
                    counter = getCounter(beach, col, counter, i);
                }
                break;
            case "left":   // if we go left, we decrease columns
                for (int i = col; i >= col - 3; i--) {
                    counter = getCounter(beach, col, counter, i);
                }

                break;
            case "right":
                for (int i = col; i <= col + 3; i++) {
                    counter = getCounter(beach, col, counter, i);
                }
                break;
        }
        return counter;
    }

    private static int getCounter(String[][] beach, int col, int counter, int i) {
        if (isValidIndex(i, col, beach)) {
            String shell = beach[i][col];
            if (!shell.equals("-")) {
                counter++;
                beach[i][col] = "-";
            }
        }
        return counter;
    }

    private static boolean isValidIndex(int row, int col, String[][] beach) {
        if (row >= 0 && row < beach.length) {
            if (col >= 0 && col < beach[row].length) {
                return true;
            }
        }
        return false;
    }

    private static void printMatrix(String[][] beach) {
        for (String[] row : beach) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}
