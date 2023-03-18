import java.util.ArrayList;
import java.util.List;


interface Component {
    void printName();
}

class Employee implements Component {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(name);
    }
}

class Department implements Component {
    String name;
    List<Component> components;

    public Department(String name, List<Component> components) {
        this.name = name;
        this.components = components;
    }

    public void printName() {
        System.out.println("Department: " + name);
        for (Component component : components) {
            component.printName();
        }
    }
}

class Team implements Component {
    String name;
    List<Component> components;

    public Team(String name, List<Component> components) {
        this.name = name;
        this.components = components;
    }

    public void printName() {
        System.out.println("Team: " + name);
        for (Component component : components) {
            component.printName();
        }
    }
}

class Manager implements Component {
    String name;
    List<Component> components;

    public Manager(String name, List<Component> components) {
        this.name = name;
        this.components = components;
    }

    public void printName() {
        System.out.println("Manager: " + name);
        for (Component component : components) {
            component.printName();
        }
    }
}

public class CompositeExample {
    public static void main(String[] args) {
        List<Component> employees = new ArrayList<>();
        employees.add(new Employee("John"));
        employees.add(new Employee("Jane"));
        employees.add(new Employee("Bob"));

        Department department = new Department("Engineering", employees);
        Team team = new Team("Product", List.of(department));
        Manager manager = new Manager("Alice", List.of(team));

        manager.printName();
    }
}

