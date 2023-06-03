package v27_memento.java;

import java.util.Stack;

// Originator class
class Calculator {
    private int result;

    public void add(int value) {
        result += value;
    }

    public void subtract(int value) {
        result -= value;
    }

    public CalculatorMemento save() {
        return new CalculatorMemento(result);
    }

    public void restore(CalculatorMemento memento) {
        result = memento.getResult();
    }

    public int getResult() {
        return result;
    }
}

// Memento class
class CalculatorMemento {
    private final int result;

    public CalculatorMemento(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}

// Caretaker class
class CalculatorHistory {
    private Stack<CalculatorMemento> history = new Stack<>();

    public void save(Calculator calculator) {
        history.push(calculator.save());
    }

    public void undo(Calculator calculator) {
        if (!history.isEmpty()) {
            calculator.restore(history.pop());
        }
    }
}

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorHistory history = new CalculatorHistory();

        calculator.add(5);
        calculator.subtract(3);
        history.save(calculator); // Save state
        System.out.println("Result: " + calculator.getResult()); // Output: Result: 2

        calculator.add(8);
        System.out.println("Result: " + calculator.getResult()); // Output: Result: 10

        history.undo(calculator); // Undo to the previous saved state
        System.out.println("Result: " + calculator.getResult()); // Output: Result: 2
    }
}