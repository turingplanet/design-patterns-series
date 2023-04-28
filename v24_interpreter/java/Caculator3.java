
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

class Multiply extends Operator {
    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}

class Divide extends Operator {
    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() / right.interpret();
    }
}

class CalcExpression {

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
            } else if (token.equals("*")) {
                Expression left = stack.pop();
                Expression right = new Number(Integer.parseInt(tokens[++i]));
                stack.push(new Multiply(left, right));
            } else if (token.equals("/")) {
                Expression left = stack.pop();
                Expression right = new Number(Integer.parseInt(tokens[++i]));
                stack.push(new Divide(left, right));
            } else {
                stack.push(new Number(Integer.parseInt(token)));
            }
        }

        return stack.pop().interpret();
    }

    public static void main(String[] args) {
        CalcExpression calc = new CalcExpression();
        System.out.println("Result: " + calc.calc("1 + 3 * 2 - 2 / 1")); // Output: Result: 7
    }
}



public class Caculator3 {
    
}