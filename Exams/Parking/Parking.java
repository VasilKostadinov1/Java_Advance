package EXAMs.Parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car -> (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)));
    }

    public Car getLatestCar() {
        return this.data.stream().min((p1, p2) -> Integer.compare(p2.getYear(), p1.getYear())).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(e->e.getManufacturer().equals(manufacturer) && e.getModel().equals(model)).findFirst().orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:",this.type))
                .append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
