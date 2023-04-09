from abc import ABC, abstractmethod

class Coffee(ABC):
    @abstractmethod
    def cost(self):
        pass

class SimpleCoffee(Coffee):
    def cost(self):
        return 2

class CoffeeDecorator(Coffee):
    def __init__(self, coffee):
        self.coffee = coffee

    def cost(self):
        return self.coffee.cost()

class MilkDecorator(CoffeeDecorator):
    def __init__(self, coffee):
        super().__init__(coffee)

    def cost(self):
        return self.coffee.cost() + 0.5

class SugarDecorator(CoffeeDecorator):
    def __init__(self, coffee):
        super().__init__(coffee)

    def cost(self):
        return self.coffee.cost() + 0.25

if __name__ == "__main__":
    coffee = SimpleCoffee()
    coffee_with_milk = MilkDecorator(coffee)
    coffee_with_milk_and_sugar = SugarDecorator(coffee_with_milk)

    print("Coffee cost: ", coffee.cost())
    print("Coffee with Milk cost: ", coffee_with_milk.cost())
    print("Coffee with Milk and Sugar cost: ", coffee_with_milk_and_sugar.cost())

