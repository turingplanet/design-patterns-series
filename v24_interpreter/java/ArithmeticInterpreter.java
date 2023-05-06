package v24_interpreter.java;

import java.util.HashMap;
import java.util.Map;

// AbstractExpression
interface Expression {
    int interpret(Context context);
}

// TerminalExpression for Numbers
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

// TerminalExpression for Variables
class VariableExpression implements Expression {
    private String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public int interpret(Context context) {
        return context.get(variableName);
    }
}

// NonTerminalExpression for Addition
class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// Context class
class Context {
    private Map<String, Integer> variables = new HashMap<>();

    public void set(String name, int value) {
        variables.put(name, value);
    }

    public int get(String name) {
        return variables.get(name);
    }
}

// Client class
public class ArithmeticInterpreter {
    public static void main(String[] args) {
        // Set up the context
        Context context = new Context();
        context.set("x", 5);
        context.set("y", 7);

        // Build the expression tree
        Expression x = new VariableExpression("x");
        Expression y = new VariableExpression("y");
        Expression sum = new AddExpression(x, y);

        // Interpret the expression
        int result = sum.interpret(context);

        System.out.println("x + y = " + result); // Output: x + y = 12
    }
}
