from abc import ABC, abstractmethod


class BankAccount(ABC):
    @abstractmethod
    def deposit(self, amount):
        pass

    @abstractmethod
    def withdraw(self, amount):
        pass


class RealBankAccount(BankAccount):
    def __init__(self, initial_balance):
        self.balance = initial_balance

    def deposit(self, amount):
        self.balance += amount
        print(f"Deposited: {amount}, new balance: {self.balance}")

    def withdraw(self, amount):
        if self.balance >= amount:
            self.balance -= amount
            print(f"Withdrew: {amount}, new balance: {self.balance}")
        else:
            print("Insufficient balance")


class BankAccountProxy(BankAccount):
    def __init__(self, user_role, initial_balance):
        self.user_role = user_role
        self.real_bank_account = RealBankAccount(initial_balance)

    def deposit(self, amount):
        if self.user_role == "Admin" or self.user_role == "User":
            self.real_bank_account.deposit(amount)
        else:
            print("Unauthorized access")

    def withdraw(self, amount):
        if self.user_role == "Admin":
            self.real_bank_account.withdraw(amount)
        else:
            print("Unauthorized access")


def main():
    admin_account = BankAccountProxy("Admin", 1000)
    admin_account.deposit(500)
    admin_account.withdraw(200)

    user_account = BankAccountProxy("User", 1000)
    user_account.deposit(500)
    user_account.withdraw(200)  # Will print "Unauthorized access"


if __name__ == "__main__":
    main()


