from abc import ABC, abstractmethod

# AbstractExpression
class Expression(ABC):
    @abstractmethod
    def interpret(self, context):
        pass

# TerminalExpression for Numbers
class NumberExpression(Expression):
    def __init__(self, number):
        self.number = number

    def interpret(self, context):
        return self.number

# TerminalExpression for Variables
class VariableExpression(Expression):
    def __init__(self, variable_name):
        self.variable_name = variable_name

    def interpret(self, context):
        return context.get(self.variable_name)

# NonTerminalExpression for Addition
class AddExpression(Expression):
    def __init__(self, left, right):
        self.left = left
        self.right = right

    def interpret(self, context):
        return self.left.interpret(context) + self.right.interpret(context)

# Context class
class Context:
    def __init__(self):
        self.variables = {}

    def set(self, name, value):
        self.variables[name] = value

    def get(self, name):
        return self.variables[name]

# Client code
if __name__ == "__main__":
    # Set up the context
    context = Context()
    context.set("x", 5)
    context.set("y", 7)

    # Build the expression tree
    x = VariableExpression("x")
    y = VariableExpression("y")
    sum = AddExpression(x, y)

    # Interpret the expression
    result = sum.interpret(context)

    print("x + y = ", result)  # Output: x + y = 12


