class Employee:
    def __init__(self, name):
        self.name = name

    def print_name(self):
        print(self.name)

employees = [Employee("John"), Employee("Jane"), Employee("Bob")]

for employee in employees:
    employee.print_name()


