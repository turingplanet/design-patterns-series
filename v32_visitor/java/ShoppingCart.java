package v32_visitor.java;

import java.util.ArrayList;
import java.util.List;

interface Item {
    void accept(Visitor visitor);
}

class Book implements Item {
    private double price;

    public Book(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Electronics implements Item {
    private double price;

    public Electronics(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Book book);
    void visit(Electronics electronics);
}

class RegularPriceVisitor implements Visitor {
    private double totalCost = 0;

    @Override
    public void visit(Book book) {
        totalCost += book.getPrice();
    }

    @Override
    public void visit(Electronics electronics) {
        totalCost += electronics.getPrice();
    }

    public double getTotalCost() {
        return totalCost;
    }
}

class DiscountPriceVisitor implements Visitor {
    private double totalCost = 0;

    @Override
    public void visit(Book book) {
        totalCost += book.getPrice() * 0.8; // 20% discount on books
    }

    @Override
    public void visit(Electronics electronics) {
        totalCost += electronics.getPrice() * 0.9; // 10% discount on electronics
    }

    public double getTotalCost() {
        return totalCost;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Book(50));
        items.add(new Book(30));
        items.add(new Electronics(100));

        RegularPriceVisitor regularVisitor = new RegularPriceVisitor();
        DiscountPriceVisitor discountVisitor = new DiscountPriceVisitor();

        for (Item item : items) {
            item.accept(regularVisitor);
            item.accept(discountVisitor);
        }

        System.out.println("Regular total cost: " + regularVisitor.getTotalCost());
        System.out.println("Discount total cost: " + discountVisitor.getTotalCost());
    }
}