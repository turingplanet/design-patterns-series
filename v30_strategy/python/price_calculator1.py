from enum import Enum

class CustomerType(Enum):
    CHILD = 1
    ADULT = 2
    SENIOR = 3

class PriceCalculator:
    @staticmethod
    def calculate_price(price, customer_type):
        if customer_type == CustomerType.CHILD:
            return price * 0.5  # 50% discount for children
        elif customer_type == CustomerType.ADULT:
            return price  # no discount for adults
        elif customer_type == CustomerType.SENIOR:
            return price * 0.8  # 20% discount for seniors
        else:
            raise ValueError('Invalid customer type')

if __name__ == "__main__":
    calculator = PriceCalculator()
    print("Children price: ", calculator.calculate_price(100, CustomerType.CHILD))
    print("Adult price: ", calculator.calculate_price(100, CustomerType.ADULT))
    print("Senior price: ", calculator.calculate_price(100, CustomerType.SENIOR))

