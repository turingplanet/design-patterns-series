from abc import ABC, abstractmethod

class Coffee(ABC):
    @abstractmethod
    def cost(self):
        pass

class SimpleCoffee(Coffee):
    def cost(self):
        return 2

class CoffeeWithMilk(Coffee):
    def cost(self):
        return 2 + 0.5

class CoffeeWithSugar(Coffee):
    def cost(self):
        return 2 + 0.25

class CoffeeWithMilkAndSugar(Coffee):
    def cost(self):
        return 2 + 0.5 + 0.25

