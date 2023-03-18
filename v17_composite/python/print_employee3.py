from abc import ABC, abstractmethod

class Component(ABC):
    @abstractmethod
    def print_name(self):
        pass

class Employee(Component):
    def __init__(self, name):
        self.name = name

    def print_name(self):
        print(self.name)

class Department(Component):
    def __init__(self, name, components=[]):
        self.name = name
        self.components = components

    def print_name(self):
        print("Department:", self.name)
        for component in self.components:
            component.print_name()

class Team(Component):
    def __init__(self, name, components=[]):
        self.name = name
        self.components = components

    def print_name(self):
        print("Team:", self.name)
        for component in self.components:
            component.print_name()

class Manager(Component):
    def __init__(self, name, components=[]):
        self.name = name
        self.components = components

    def print_name(self):
        print("Manager:", self.name)
        for component in self.components:
            component.print_name()

employees = [Employee("John"), Employee("Jane"), Employee("Bob")]
department = Department("Engineering", employees)
team = Team("Product", [department])
manager = Manager("Alice", [team])

manager.print_name()


