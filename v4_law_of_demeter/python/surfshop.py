class Card:

    balance = 10

class Customer:

    card = Card()

    def get_card(self):
        return self.card

class SurfShop:

    def charge_customer(self, c: Customer, fee: float):
        c.get_card().balance -= fee

customer = Customer()
SurfShop().charge_customer(customer, 1.0)
