from abc import ABC, abstractmethod


class DispenseChain(ABC):

    @abstractmethod
    def set_next_chain(self, next_chain):
        pass

    @abstractmethod
    def dispense(self, currency):
        pass


class Currency:

    def __init__(self, amount):
        self.amount = amount

    def get_amount(self):
        return self.amount


class Dollar50Dispenser(DispenseChain):

    def __init__(self):
        self.chain = None

    def set_next_chain(self, next_chain):
        self.chain = next_chain

    def dispense(self, currency):
        if currency.get_amount() >= 50:
            number_of_notes = currency.get_amount() // 50
            remainder = currency.get_amount() % 50
            print(f"Dispensing {number_of_notes} 50$ note")
            if remainder != 0:
                self.chain.dispense(Currency(remainder))
        else:
            self.chain.dispense(currency)


class Dollar20Dispenser(DispenseChain):

    def __init__(self):
        self.chain = None

    def set_next_chain(self, next_chain):
        self.chain = next_chain

    def dispense(self, currency):
        if currency.get_amount() >= 20:
            number_of_notes = currency.get_amount() // 20
            remainder = currency.get_amount() % 20
            print(f"Dispensing {number_of_notes} 20$ note")
            if remainder != 0:
                self.chain.dispense(Currency(remainder))
        else:
            self.chain.dispense(currency)


class Dollar10Dispenser(DispenseChain):

    def __init__(self):
        self.chain = None

    def set_next_chain(self, next_chain):
        self.chain = next_chain

    def dispense(self, currency):
        if currency.get_amount() >= 10:
            number_of_notes = currency.get_amount() // 10
            remainder = currency.get_amount() % 10
            print(f"Dispensing {number_of_notes} 10$ note")
            if remainder != 0:
                self.chain.dispense(Currency(remainder))
        else:
            self.chain.dispense(currency)


class ATMDispenser:

    def __init__(self):
        self.c1 = Dollar50Dispenser()
        c2 = Dollar20Dispenser()
        c3 = Dollar10Dispenser()

        self.c1.set_next_chain(c2)
        c2.set_next_chain(c3)

    def dispense_money(self, currency):
        if currency.get_amount() % 10 != 0:
            print("Amount should be in multiple of 10.")
            return

        self.c1.dispense(currency)


if __name__ == "__main__":
    atm_dispenser = ATMDispenser()
    currency = Currency(370)
    atm_dispenser.dispense_money(currency)


