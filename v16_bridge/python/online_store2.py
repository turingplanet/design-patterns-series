from abc import ABC, abstractmethod

class Payment(ABC):
    @abstractmethod
    def processPayment(self):
        pass

class CreditCardPayment(Payment):
    def processPayment(self):
        print("Processing credit card payment")

class WeChatPayment(Payment):
    def processPayment(self):
        print("Processing wechat payment")

class Product(ABC):
    def __init__(self, payment: Payment):
        self.payment = payment

    @abstractmethod
    def purchase(self):
        pass

class Book(Product):
    def __init__(self, payment: Payment):
        super().__init__(payment)

    def purchase(self):
        self.payment.processPayment()
        print("Purchased book")

class Electronics(Product):
    def __init__(self, payment: Payment):
        super().__init__(payment)

    def purchase(self):
        self.payment.processPayment()
        print("Purchased electronics")

if __name__ == "__main__":
    creditCardPayment = CreditCardPayment()
    wechatPayment = WeChatPayment()
    book = Book(creditCardPayment)
    book.purchase()
    electronics = Electronics(creditCardPayment)
    electronics.purchase()
    book2 = Book(wechatPayment)
    book2.purchase()


