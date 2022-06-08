package DefiningClasses.Google;

public class Company {
    private final String name;
    private final String department;
    private final double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    //JeleInc Jelior 777.77
    public String format(){
        return String.format("%s %s %.2f",name,department,salary);
    }
}
