class Card:

    balance = 10

    def deduct(self, fee: float): 
        self.balance -= fee

class Customer:

    card = Card()

    def pay(self, fee: float):
        self.card.deduct(fee)

class SurfShop2:

    def charge_customer(self, c: Customer, fee: float):
        c.pay(fee)

customer = Customer()
SurfShop2().charge_customer(customer, 1.0)

