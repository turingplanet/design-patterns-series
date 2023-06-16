package v32_visitor.java;

interface Shape {
    void draw();
    void resize();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public void resize() {
        System.out.println("Resizing a circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    public void resize() {
        System.out.println("Resizing a rectangle");
    }
}

public class ShapeMain1 {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();

        circle.resize();
        rectangle.resize();
    }
}


