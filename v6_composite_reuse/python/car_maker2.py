class Car:
    enery = None
    color = None
    def __init__(self, energy, color):
        self.enery = energy
        self.color = color
    
    def move(self):
        print(f'{self.enery.__str__()} {self.color.__str__()}')

class Energy:
    pass

class Color:
    pass

class Gasoline(Energy):
    def __str__(self): return 'gasoline'

class Electric(Energy):
    def __str__(self): return 'electric'

class Red(Color):
    def __str__(self): return 'red'

class Blue(Color):
    def __str__(self): return 'blue'

Car(Gasoline(), Red()).move()
Car(Electric(), Blue()).move()
