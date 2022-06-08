package DefiningClasses.CarSalesman_05;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engineMap = new HashMap<>();  // problem is similar to "Company Roster" !!!

        //N which will specify how many lines of engines you will receive
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = null;                                         // declare
            if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);  // initilize

            } else if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("^\\s+$")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engineMap.putIfAbsent(model, engine);
        }

        List<Car> cars = new LinkedList<>();
        //receive a number M – specifying the number of Cars that will follow
        int m = Integer.parseInt(scanner.nextLine());  // numbers of cars
        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            //FordFocus V4-33 1300 Silver
            //"<Model> <Engine> <Weight> <Color>"
            String model = tokens[0];
            Engine engine = engineMap.get(tokens[1]);  // get it from the Map !!
            Car car =null;
            if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model,engine,weight,color);
            } else if (tokens.length == 2) {
                car = new Car(model,engine);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("^\\s+$")) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model,engine,weight);

                } else {
                    String color = tokens[2];
                    car = new Car(model,engine,color);

                }
            }
            cars.add(car);
        }
        cars.forEach(c-> System.out.println(c));
    }
}






