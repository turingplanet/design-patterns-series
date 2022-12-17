import abc

class Calculator:

    @abc.abstractmethod
    def test():
        raise NotImplementedError
    
    def calculate(self, n1, n2):
        return n1 + n2

class SuperCalculator(Calculator):

    def test():
        print('super test')

    def calculate(self, n1, n2): # It's dangerous to overwrite non-abstract methods
        return n1 - n2

c = Calculator()
print(c.calculate(1, 3))
sc = SuperCalculator()
print(sc.calculate(1, 3))
