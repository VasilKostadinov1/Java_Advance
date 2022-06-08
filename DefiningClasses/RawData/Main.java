package DefiningClasses.RawData_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        //"<Model> <EngineSpeed-NA> <EnginePower> <CargoWeight-NA> <CargoType>
        // <Tire1Pressure> <Tire1Age-NA> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>
        while (n-- > 0) {  //ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car(input[0], Integer.parseInt(input[2]), input[4], Double.parseDouble(input[5])
                    , Double.parseDouble(input[7]), Double.parseDouble(input[9]), Double.parseDouble(input[11]));
            carList.add(car);   // fill-in the list
        }
        //After the N lines you will receive a single line with one of 2 commands "fragile" or "flamable
        String input = scanner.nextLine();

        if (input.equals("fragile")) {  //Cargo Type is "fragile" with a tire whose pressure is  < 1
            carList.stream().filter(e -> e.getCargoType().equals("fragile")
                    && e.tirePressure()).forEach(System.out::println);
        } else {
            carList.stream().filter(e -> e.getCargoType().equals("flamable")  //Cargo Type is "flamable" and have Engine Power > 250
                    && e.getEnginePower() > 250).forEach(System.out::println);
        }
    }
}
