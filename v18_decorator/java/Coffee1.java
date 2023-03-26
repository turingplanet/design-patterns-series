package v18_decorator.java;

interface Coffee {
    double cost();
}

class SimpleCoffee implements Coffee {
    public double cost() {
        return 2;
    }
}

class CoffeeWithMilk implements Coffee {
    public double cost() {
        return 2 + 0.5;
    }
}

class CoffeeWithSugar implements Coffee {
    public double cost() {
        return 2 + 0.25;
    }
}

class CoffeeWithMilkAndSugar implements Coffee {
    public double cost() {
        return 2 + 0.5 + 0.25;
    }
}