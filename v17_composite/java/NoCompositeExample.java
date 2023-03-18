import java.util.ArrayList;
import java.util.List;


class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    void printName() {
        System.out.println(name);
    }
}

class Department {
    String name;
    List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
}

class Team {
    String name;
    List<Department> departments;

    public Team(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }
}

class Manager {
    String name;
    List<Team> teams;

    public Manager(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }
}

public class NoCompositeExample {

    static void printManagerNames(Manager manager) {
        System.out.println("Manager: " + manager.name);
        for (Team team : manager.teams) {
            printTeamNames(team);
        }
    }

    static void printTeamNames(Team team) {
        System.out.println("Team: " + team.name);
        for (Department department : team.departments) {
            printDepartmentNames(department);
        }
    }

    static void printDepartmentNames(Department department) {
        System.out.println("Department: " + department.name);
        for (Employee employee : department.employees) {
            employee.printName();
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John"));
        employees.add(new Employee("Jane"));
        employees.add(new Employee("Bob"));

        Department department = new Department("Engineering", employees);
        Team team = new Team("Product", List.of(department));
        Manager manager = new Manager("Alice", List.of(team));

        printManagerNames(manager);
    }
}
