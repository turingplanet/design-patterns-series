from abc import ABC, abstractmethod

class PricingStrategy(ABC):
    @abstractmethod
    def calculate_price(self, price):
        pass

class ChildrenPricingStrategy(PricingStrategy):
    def calculate_price(self, price):
        return price * 0.5  # 50% discount for children

class AdultPricingStrategy(PricingStrategy):
    def calculate_price(self, price):
        return price  # no discount for adults

class SeniorPricingStrategy(PricingStrategy):
    def calculate_price(self, price):
        return price * 0.8  # 20% discount for seniors

class TeenagerPricingStrategy(PricingStrategy):
    def calculate_price(self, price):
        return price * 0.75  # 25% discount for teenagers

class HolidayPricingStrategy(PricingStrategy):
    def calculate_price(self, price):
        return price * 0.9  # 10% discount on holidays for everyone

class PriceCalculator:
    def __init__(self, strategy):
        self.strategy = strategy

    def calculate(self, price):
        return self.strategy.calculate_price(price)

if __name__ == '__main__':
    calculator = PriceCalculator(ChildrenPricingStrategy())
    print(f"Children price: {calculator.calculate(100)}")

    calculator = PriceCalculator(AdultPricingStrategy())
    print(f"Adult price: {calculator.calculate(100)}")

    calculator = PriceCalculator(SeniorPricingStrategy())
    print(f"Senior price: {calculator.calculate(100)}")

    calculator = PriceCalculator(TeenagerPricingStrategy())
    print(f"Teenager price: {calculator.calculate(100)}")

    calculator = PriceCalculator(HolidayPricingStrategy())
    print(f"Holiday price: {calculator.calculate(100)}")


