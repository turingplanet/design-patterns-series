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

public class MessageFilter2 {

    public static void main(String[] args) {
        Expression rule1 = new ContainsKeywordExpression("urgent");
        Expression rule2 = new ContainsKeywordExpression("important");
        Expression rule3 = new AndExpression(rule1, rule2);
        Expression filterRule = new OrExpression(rule1, rule2);

        String message1 = "This is an urgent message";
        String message2 = "This is an important message";
        String message3 = "This is an unimportant message";

        System.out.println("Message 1: " + filterRule.interpret(message1)); // true
        System.out.println("Message 2: " + filterRule.interpret(message2)); // true
        System.out.println("Message 3: " + filterRule.interpret(message3)); // false
        System.out.println("Message 1 & 2: " + rule3.interpret(message1 + " " + message2)); // true
    }
}
