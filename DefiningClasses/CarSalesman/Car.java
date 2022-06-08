package DefiningClasses.CarSalesman_05;

public class Car {

    //model, engine, weight and color
    private String model;
    private Engine engine;   // !!! Engine engine
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    // A Car's weight and color are optional.=> use CHAIN CONSTRUCTORS !!!
    // CHAIN CONSTRUCTORS !!!
    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }
    //<CarModel>:
    // ..... get info for the engine !!!!
    //Weight: <CarWeight>
    //Color: <CarColor>

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.model);

        sb.append(":")
                .append(System.lineSeparator())  // new line
                .append(this.engine)
                .append(System.lineSeparator());
        sb.append("Weight: ")
                .append(this.weight == 0 ? 0 : this.weight)
                .append(System.lineSeparator());
        sb.append("Color: ")
                .append(this.color)
                .append(System.lineSeparator());
        return sb.toString().trim();
    }
}
