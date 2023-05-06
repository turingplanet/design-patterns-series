package v24_interpreter.java;

interface Expression {
    boolean interpret(String message);
}

class ContainsKeywordExpression implements Expression {

    private String keyword;

    public ContainsKeywordExpression(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean interpret(String message) {
        return message.contains(keyword);
    }
}



class AndExpression implements Expression {

    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String message) {
        return expr1.interpret(message) && expr2.interpret(message);
    }
}

class OrExpression implements Expression {

    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String message) {
        return expr1.interpret(message) || expr2.interpret(message);
    }
}

// StartsWithExpression
class StartsWithExpression implements Expression {
    private String prefix;

    public StartsWithExpression(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public boolean interpret(String message) {
        return message.startsWith(prefix);
    }
}

public class MessageFilter3 {

    public static void main(String[] args) {
        Expression rule1 = new ContainsKeywordExpression("urgent");
        Expression rule2 = new ContainsKeywordExpression("important");
        Expression rule3 = new StartsWithExpression("This");
        Expression filterRule = new OrExpression(new AndExpression(rule1, rule3), rule2);

        String message1 = "This is an urgent message";
        String message2 = "This is an important message";
        String message3 = "This is an unimportant message";

        System.out.println("Message 1: " + filterRule.interpret(message1)); // true
        System.out.println("Message 2: " + filterRule.interpret(message2)); // true
        System.out.println("Message 3: " + filterRule.interpret(message3)); // false
    }
}

