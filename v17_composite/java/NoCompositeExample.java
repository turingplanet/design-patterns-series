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

class Team {
    String name;
    List<Employee> employees;

    public Team(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
}

class Department {
    String name;
    List<Team> teams;

    public Department(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }
}

class Manager {
    String name;
    List<Department> departments;

    public Manager(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }
}

public class NoCompositeExample {

    static void printTeamNames(Team team) {
        System.out.println("Team: " + team.name);
        for (Employee employee: team.employees) {
            employee.printName();
        }
    }

    static void printDepartmentNames(Department department) {
        System.out.println("Department: " + department.name);
        for (Team team: department.teams) {
            printTeamNames(team);
        }
    }

    static void printManagerNames(Manager manager) {
        System.out.println("Manager: " + manager.name);
        for (Department team : manager.departments) {
            printDepartmentNames(team);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John"));
        employees.add(new Employee("Jane"));
        employees.add(new Employee("Bob"));

        Team team = new Team("Engineering", employees);
        Department department = new Department("Product", List.of(team));
        Manager manager = new Manager("Alice", List.of(department));
        
        printManagerNames(manager);
    }
}
