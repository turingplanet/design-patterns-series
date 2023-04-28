package v24_interpreter.java;
import java.util.Stack;

interface Expression {
    int interpret();
}

class Number implements Expression {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

abstract class Operator implements Expression {
    protected Expression left, right;

    public Operator(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

class Add extends Operator {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class Subtract extends Operator {
    public Subtract(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

public class Caculator2 {

    public int calc(String expression) {
        Stack<Expression> stack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.equals("+")) {
                Expression left = stack.pop();
                Expression right = new Number(Integer.parseInt(tokens[++i]));
                stack.push(new Add(left, right));
            } else if (token.equals("-")) {
                Expression left = stack.pop();
                Expression right = new Number(Integer.parseInt(tokens[++i]));
                stack.push(new Subtract(left, right));
            } else {
                stack.push(new Number(Integer.parseInt(token)));
            }
        }

        return stack.pop().interpret();
    }

    public static void main(String[] args) {
        Caculator2 calc = new Caculator2();
        System.out.println("Result: " + calc.calc("1 + 3 - 2 + 8")); // Output: Result: 10
    }
}
