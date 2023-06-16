package v32_visitor.java;

interface Shape {
    void accept(Visitor visitor);
}

class Circle implements Shape {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

class DrawVisitor implements Visitor {
    public void visit(Circle circle) {
        System.out.println("Drawing a circle");
    }

    public void visit(Rectangle rectangle) {
        System.out.println("Drawing a rectangle");
    }
}

class ResizeVisitor implements Visitor {
    public void visit(Circle circle) {
        System.out.println("Resizing a circle");
    }

    public void visit(Rectangle rectangle) {
        System.out.println("Resizing a rectangle");
    }
}

public class ShapeMain2 {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        Visitor drawVisitor = new DrawVisitor();
        Visitor resizeVisitor = new ResizeVisitor();

        circle.accept(drawVisitor);
        rectangle.accept(drawVisitor);

        circle.accept(resizeVisitor);
        rectangle.accept(resizeVisitor);
    }
}
