package v30_strategy.java;

interface PricingStrategy {
    double calculatePrice(double price);
}

class ChildrenPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.5; // 50% discount for children
    }
}

class AdultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        return price; // no discount for adults
    }
}

class SeniorPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.8; // 20% discount for seniors
    }
}

class TeenagerPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.75; // 25% discount for teenagers
    }
}

class HolidayPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.9; // 10% discount on holidays for everyone
    }
}

class PriceCalculator {
    private PricingStrategy strategy;

    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double price) {
        return this.strategy.calculatePrice(price);
    }
}

public class PriceCalculatorMain3 {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator(new ChildrenPricingStrategy());
        System.out.println("Children price: " + calculator.calculate(100));

        calculator = new PriceCalculator(new AdultPricingStrategy());
        System.out.println("Adult price: " + calculator.calculate(100));

        calculator = new PriceCalculator(new SeniorPricingStrategy());
        System.out.println("Senior price: " + calculator.calculate(100));

        calculator = new PriceCalculator(new TeenagerPricingStrategy());
        System.out.println("Teenager price: " + calculator.calculate(100));

        calculator = new PriceCalculator(new HolidayPricingStrategy());
        System.out.println("Holiday price: " + calculator.calculate(100));
    }
}

