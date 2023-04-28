package v24_interpreter.java;

public class Caculator1 {
    
}

class CalcExpression {
    public int calc(String expression) {
        String[] tokens = expression.split(" ");
        int result = 0;
        char operator = '+';

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-")) {
                operator = token.charAt(0);
            } else {
                int number = Integer.parseInt(token);
                if (operator == '+') {
                    result += number;
                } else {
                    result -= number;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CalcExpression calc = new CalcExpression();
        System.out.println("Result: " + calc.calc("1 + 3 - 2 + 8")); // Output: Result: 10
    }
}