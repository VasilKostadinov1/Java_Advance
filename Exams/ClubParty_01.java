package EXAMs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ClubParty_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hallCapacity = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");

        Deque<String> hallsAndReservations = initilizeStack(input, hallCapacity);

        Deque<String> halls = new ArrayDeque<>();
        Deque<Integer> currentHallReservation = new ArrayDeque<>();
        int currentHallCapacity = 0;

        while (!hallsAndReservations.isEmpty()) {

            String currentElement = hallsAndReservations.pop();
            if (Character.isDigit(currentElement.charAt(0))) {
                int reservation = Integer.parseInt(currentElement);

                if (currentHallCapacity + reservation > hallCapacity) {
                    printHall(halls, currentHallReservation);
                    currentHallCapacity = 0; // when overloaded
                }
                // if there is no empty room, skip reservation
                if (halls.isEmpty()){
                    continue;
                }
                currentHallCapacity += reservation;
                currentHallReservation.add(reservation);
            } else {
                halls.add(currentElement);
            }
        }
        // 60
        // 1 20 b 20 20 a
    }

    private static void printHall(Deque<String> halls, Deque<Integer> currentHallReservation) {
        System.out.print(halls.remove() + " -> ");
        while (!currentHallReservation.isEmpty()) {
            if (currentHallReservation.size() == 1) {
                System.out.print(currentHallReservation.remove());
            } else {
                System.out.print(currentHallReservation.remove() + ", ");
            }
        }
        System.out.println();
    }

    private static Deque<String> initilizeStack(String[] input, int hallCapacity) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }
        return stack;
    }
}
