class Calculator:
    def __init__(self):
        self.result = 0

    def add(self, value):
        self.result += value

    def subtract(self, value):
        self.result -= value

    def save(self):
        return self.CalculatorMemento(self.result)

    def restore(self, memento):
        self.result = memento.get_result()

    def get_result(self):
        return self.result

    class CalculatorMemento:
        def __init__(self, result):
            self.result = result

        def get_result(self):
            return self.result


class CalculatorHistory:
    def __init__(self):
        self.history = []

    def save(self, calculator):
        self.history.append(calculator.save())

    def undo(self, calculator):
        if self.history:
            calculator.restore(self.history.pop())


def main():
    calculator = Calculator()
    history = CalculatorHistory()

    calculator.add(5)
    calculator.subtract(3)
    history.save(calculator)  # Save state
    print("Result: " + str(calculator.get_result()))  # Output: Result: 2

    calculator.add(8)
    print("Result: " + str(calculator.get_result()))  # Output: Result: 10

    history.undo(calculator)  # Undo to the previous saved state
    print("Result: " + str(calculator.get_result()))  # Output: Result: 2


if __name__ == "__main__":
    main()


