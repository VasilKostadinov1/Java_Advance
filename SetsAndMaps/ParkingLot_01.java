package SetsAndMapsAdvance_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> parkingLot = new LinkedHashSet<>();
        String input = scanner.nextLine();

        while (!input.equals("END")){
            String [] inputData = input.split(", ");
            String inOrOut = inputData[0];
            String number = inputData[1];
            if (inOrOut.equals("IN")){
                parkingLot.add(number);
            }else {
                parkingLot.remove(number);
            }
            input = scanner.nextLine();
        }
        String output = parkingLot.isEmpty()
                ? "Parking Lot is Empty"
                : parkingLot.stream().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(output);

    }
}
