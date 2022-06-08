package DefiningClasses.Cooking;

import java.util.ArrayList;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        return employees.stream().min((a,b)->Integer.compare(b.getAge(),a.getAge())).orElse(null);

    }
    public Employee getEmployee(String name){
        return employees.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder(String.format("Employees working at Bakery %s:", getName()));
        for (Employee e : employees) {
            sb.append(System.lineSeparator());
            sb.append(e.toString());
        }
        //this.employees.forEach(e->sb.append(System.lineSeparator()).append(e));
        return sb.toString().trim();
    }

}
