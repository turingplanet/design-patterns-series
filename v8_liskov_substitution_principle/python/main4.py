class Calculator:

    def calculate(self, n1, n2):
        return n1 + n2

class SuperCalculator(Calculator):

    def substract(self, n1, n2):
        return n1 - n2

c = Calculator()
sc = SuperCalculator()
print(c.calculate(1, 2))
print(sc.calculate(1, 2))
print(sc.substract(10, 5))
# c.substract(10, 5) # Error
