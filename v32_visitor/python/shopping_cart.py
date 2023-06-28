from abc import ABC, abstractmethod

class Item(ABC):
    @abstractmethod
    def accept(self, visitor):
        pass

class Book(Item):
    def __init__(self, price):
        self.price = price

    def get_price(self):
        return self.price

    def accept(self, visitor):
        visitor.visit_book(self)

class Electronics(Item):
    def __init__(self, price):
        self.price = price

    def get_price(self):
        return self.price

    def accept(self, visitor):
        visitor.visit_electronics(self)

class Visitor(ABC):
    @abstractmethod
    def visit_book(self, book):
        pass

    @abstractmethod
    def visit_electronics(self, electronics):
        pass

class RegularPriceVisitor(Visitor):
    def __init__(self):
        self.total_cost = 0

    def visit_book(self, book):
        self.total_cost += book.get_price()

    def visit_electronics(self, electronics):
        self.total_cost += electronics.get_price()

    def get_total_cost(self):
        return self.total_cost

class DiscountPriceVisitor(Visitor):
    def __init__(self):
        self.total_cost = 0

    def visit_book(self, book):
        self.total_cost += book.get_price() * 0.8  # 20% discount on books

    def visit_electronics(self, electronics):
        self.total_cost += electronics.get_price() * 0.9  # 10% discount on electronics

    def get_total_cost(self):
        return self.total_cost

def main():
    items = [Book(50), Book(30), Electronics(100)]

    regular_visitor = RegularPriceVisitor()
    discount_visitor = DiscountPriceVisitor()

    for item in items:
        item.accept(regular_visitor)
        item.accept(discount_visitor)

    print("Regular total cost: ", regular_visitor.get_total_cost())
    print("Discount total cost: ", discount_visitor.get_total_cost())

if __name__ == "__main__":
    main()

