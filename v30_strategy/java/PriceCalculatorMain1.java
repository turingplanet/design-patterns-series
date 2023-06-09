package v30_strategy.java;

class PriceCalculator {
    public enum CustomerType {
        CHILD,
        ADULT,
        SENIOR
    }

    public double calculatePrice(double price, CustomerType customerType) {
        switch (customerType) {
            case CHILD:
                return price * 0.5; // 50% discount for children
            case ADULT:
                return price; // no discount for adults
            case SENIOR:
                return price * 0.8; // 20% discount for seniors
            default:
                throw new IllegalArgumentException("Invalid customer type");
        }
    }
}

public class PriceCalculatorMain1 {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        System.out.println("Children price: " + calculator.calculatePrice(100, PriceCalculator.CustomerType.CHILD));
        System.out.println("Adult price: " + calculator.calculatePrice(100, PriceCalculator.CustomerType.ADULT));
        System.out.println("Senior price: " + calculator.calculatePrice(100, PriceCalculator.CustomerType.SENIOR));
    }
}

