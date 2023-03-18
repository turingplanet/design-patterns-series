class Employee:
    def __init__(self, name):
        self.name = name

    def print_name(self):
        print(self.name)

class Department:
    def __init__(self, name, employees=[]):
        self.name = name
        self.employees = employees

class Team:
    def __init__(self, name, departments=[]):
        self.name = name
        self.departments = departments

class Manager:
    def __init__(self, name, teams=[]):
        self.name = name
        self.teams = teams

def print_manager_names(manager):
    print("Manager:", manager.name)
    for team in manager.teams:
        print_team_names(team)

def print_team_names(team):
    print("Team:", team.name)
    for department in team.departments:
        print_department_names(department)

def print_department_names(department):
    print("Department:", department.name)
    for employee in department.employees:
        employee.print_name()

employees = [Employee("John"), Employee("Jane"), Employee("Bob")]
department = Department("Engineering", employees)
team = Team("Product", [department])
manager = Manager("Alice", [team])

print_manager_names(manager)



