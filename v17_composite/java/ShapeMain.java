package v17_composite.java;
import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract double getArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

class ShapeGroup extends Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public double getArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}

public class ShapeMain {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(4);

        ShapeGroup shapeGroup1 = new ShapeGroup();
        shapeGroup1.addShape(circle);
        shapeGroup1.addShape(square);

        Circle circle2 = new Circle(3);
        ShapeGroup shapeGroup2 = new ShapeGroup();
        shapeGroup2.addShape(circle2);

        ShapeGroup mainGroup = new ShapeGroup();
        mainGroup.addShape(shapeGroup1);
        mainGroup.addShape(shapeGroup2);

        System.out.println("Total area: " + mainGroup.getArea());
    }
}
