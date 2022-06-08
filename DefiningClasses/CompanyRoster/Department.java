package DefiningClasses.CompanyRoster_02;

import java.util.ArrayList;
import java.util.List;

public class Department {

    //Hint: you can define a Department class that holds list of employees.

    private String name;
    List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees= new ArrayList<>();  // Initialize the List !!! otherwise = 0
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }
    public double getAverageSalary(){
        return this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

}
