package DefiningClasses.RawData_04;

public class Car {

    //Define a class Car that holds information about :
    // model, engine, cargo and a collection of exactly 4 tires
    private String model;
    private int enginePower;
    private String cargoType;
    private double tire1;
    private double tire2;
    private double tire3;
    private double tire4;

    public Car(String model, int enginePower, String cargoType, double tire1, double tire2, double tire3, double tire4) {
        this.model = model;
        this.enginePower = enginePower;
        this.cargoType = cargoType;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    //if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1
    Boolean tirePressure() {
        return getTire1() < 1 || getTire2() < 1 || getTire3() < 1 || getTire4() < 1;
    }

    @Override
    public String toString() {
        return String.format("%s", getModel());
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getTire1() {
        return tire1;
    }

    public double getTire2() {
        return tire2;
    }

    public double getTire3() {
        return tire3;
    }

    public double getTire4() {
        return tire4;
    }



}
