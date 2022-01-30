package EXAMs.Openning_03;

import java.util.ArrayList;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>(); // initialize the employees with a new instance of the collection
    }
    // do we need getters and setters ? or probably only getters. Need Getters for Method getOldest..., etc.

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void add(Employee employee) {      // adds an entity to the data if there is room for him/her
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {      // removes an employee by given name, if such exists
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {      // returns the oldest employee.
        return this.employees.stream().min((a, b) -> Integer.compare(b.getAge(), a.getAge())).orElse(null);
    }

    public Employee getEmployee(String name) {  // returns the employee with the given name.
        return this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Employees working at Bakery %s:", this.getName()));
        this.employees.forEach(e -> sb.append(System.lineSeparator()).append(e));
        return sb.toString();
    }
}
