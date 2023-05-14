class Expression:
    def interpret(self):
        pass

class PrintExpression(Expression):
    def __init__(self, message):
        self.message = message

    def interpret(self):
        print(self.message)

class RepeatExpression(Expression):
    def __init__(self, repeat_count, expression):
        self.repeat_count = repeat_count
        self.expression = expression

    def interpret(self):
        for i in range(self.repeat_count):
            self.expression.interpret()

def main():
    command = "REPEAT 3 TIMES: PRINT Hello"

    # Split the command into words based on whitespace
    words = command.split(" ")

    # Handle the command
    if words[0].upper() == "REPEAT":
        repeat_count = int(words[1])

        # Create the TerminalExpression for PRINT
        print_expression = PrintExpression(words[4])

        # Create the NonTerminalExpression for REPEAT
        repeat_expression = RepeatExpression(repeat_count, print_expression)

        # Interpret the command
        repeat_expression.interpret()

if __name__ == "__main__":
    main()

