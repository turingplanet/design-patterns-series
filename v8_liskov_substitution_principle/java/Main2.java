package v8_liskov_substitution_principle.java;

public class Main2 {
    
}

class Calculator {
	public int calculate(int n1, int n2) { return n1 + n2; }
}

class SuperCalculator extends Calculator {
	private int sum = 10;
	public int add(int n1, int n2) { return n1 + n2;}
	public int subtract(int n1, int n2) { return n1 - n2;}
}


