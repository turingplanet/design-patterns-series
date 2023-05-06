package v24_interpreter.java;

// AbstractExpression
interface Expression {
    void interpret();
}

// TerminalExpression for PRINT
class PrintExpression implements Expression {
    private String message;

    public PrintExpression(String message) {
        this.message = message;
    }

    @Override
    public void interpret() {
        System.out.println(message);
    }
}

// NonTerminalExpression for REPEAT
class RepeatExpression implements Expression {
    private int repeatCount;
    private Expression expression;

    public RepeatExpression(int repeatCount, Expression expression) {
        this.repeatCount = repeatCount;
        this.expression = expression;
    }

    @Override
    public void interpret() {
        for (int i = 0; i < repeatCount; i++) {
            expression.interpret();
        }
    }
}

// TerminalExpression for REVERSE
class ReverseExpression implements Expression {
    private String message;

    public ReverseExpression(String message) {
        this.message = message;
    }

    @Override
    public void interpret() {
        System.out.println(new StringBuilder(message).reverse().toString());
    }
}

// Client class
public class SimpleInterpreter3 {
    public static void main(String[] args) {
        String command = "REPEAT 3 TIMES: REVERSE Hello";

        // Split the command into words based on whitespace
        String[] words = command.split(" ");

        //Handle the command
        if (words[0].equalsIgnoreCase("REPEAT")) {
            int repeatCount = Integer.parseInt(words[1]);

            // Create the TerminalExpression for the desired command
            Expression expression;
            if (words[3].equalsIgnoreCase("PRINT")) {
                expression = new PrintExpression(words[4]);
            } else if (words[3].equalsIgnoreCase("REVERSE")) {
                expression = new ReverseExpression(words[4]);
            } else {
                throw new IllegalArgumentException("Unsupported command: " + words[3]);
            }

            // Create the NonTerminalExpression for REPEAT
            Expression repeatExpression = new RepeatExpression(repeatCount, expression);

            // Interpret the command
            repeatExpression.interpret();
        }
    }
}
