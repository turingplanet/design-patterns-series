package v8_liskov_substitution_principle.java;

public class Main1 {

    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.calculate(5, 10));
        SuperCalculator c2 = new SuperCalculator();
        System.out.println(c2.calculate(5, 10));
    }
    
}

class Calculator {
    public int calculate(int n1, int n2) {
        return n1 + n2;
    }
}

class SuperCalculator {
    public int calculate(int n1, int n2) {
        return n1 - n2;
    }
}
