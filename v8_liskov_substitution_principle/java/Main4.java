package v8_liskov_substitution_principle.java;

public class Main4 {

    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        int x = 1;
        int y = 2;
        int addResult = c1.calculate(x, y);
        System.out.println(addResult);

        SuperCalculator c2 = new SuperCalculator();
        int subtractResult = c2.subtract(x, y);
        System.out.println(subtractResult);
    }
}

class Calculator {
	public int calculate(int n1, int n2) { return n1 + n2; }
}

class SuperCalculator extends Calculator {
	public int subtract(int n1, int n2) { return n1 - n2;}
}

