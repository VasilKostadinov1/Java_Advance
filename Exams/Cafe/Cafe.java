package EXAMs.Cafe_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {

    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index != -1) {
            employees.remove(index);
            return true;
        }
        return false;
//        int sizeForRemove = employees.size();
//         employees.removeIf(employee -> employee.getName().equals(name));
//         return sizeForRemove != employees.size();
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employees working at Cafe ").append(name).append(":").append(System.lineSeparator());
        employees.forEach(employee -> builder.append(employee.toString()).append(System.lineSeparator()));
        return builder.toString();
    }
}
