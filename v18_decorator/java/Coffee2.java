package v18_decorator.java;
 

interface Coffee {
    double cost();
}

class SimpleCoffee implements Coffee {
    public double cost() {
        return 2;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 0.25;
    }
}

public class Coffee2 {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        Coffee coffeeWithMilk = new MilkDecorator(coffee);
        Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);

        System.out.println("Coffee cost: " + coffee.cost());
        System.out.println("Coffee with Milk cost: " + coffeeWithMilk.cost());
        System.out.println("Coffee with Milk and Sugar cost: " + coffeeWithMilkAndSugar.cost());
    }
}
