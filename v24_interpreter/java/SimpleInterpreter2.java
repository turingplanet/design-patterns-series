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

// Client class
public class SimpleInterpreter2 {
    public static void main(String[] args) {
        String command = "REPEAT 3 TIMES: PRINT Hello";

        // Split the command into words based on whitespace
        String[] words = command.split(" ");

        //Handle the command
        if (words[0].equalsIgnoreCase("REPEAT")) {
            int repeatCount = Integer.parseInt(words[1]);

            // Create the TerminalExpression for PRINT
            Expression printExpression = new PrintExpression(words[4]);

            // Create the NonTerminalExpression for REPEAT
            Expression repeatExpression = new RepeatExpression(repeatCount, printExpression);

            // Interpret the command
            repeatExpression.interpret();
        }
    }
}

