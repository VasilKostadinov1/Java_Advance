package DefiningClasses.CarSalesman_05;

public class Engine {

    //model, power, displacement and efficiency
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    // CHAIN CONSTRUCTORS !!!
    //Engine's  displacements, and efficiency are optional.
    public Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    /*<EngineModel>:
    Power: <EnginePower>
    Displacement: <EngineDisplacement>
    Efficiency: <EngineEfficiency>
    */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.model);
        sb.append(":")
                .append(System.lineSeparator());  // new line
        sb.append("Power: ")
                .append(this.power)
                .append(System.lineSeparator());
        sb.append("Displacement: ")
                .append(this.displacement == 0 ? "n/a" : this.displacement)
                .append(System.lineSeparator());
        sb.append("Efficiency: ")
                .append(this.efficiency)
                .append(System.lineSeparator());
        return sb.toString().trim();
    }
}
