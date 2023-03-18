package v17_composite.java;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John"));
        employees.add(new Employee("Jane"));
        employees.add(new Employee("Bob"));
        for (Employee e: employees) {
            e.printName();
        }
    }
}
