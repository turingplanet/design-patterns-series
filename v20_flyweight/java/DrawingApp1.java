package v20_flyweight.java;

class Circle {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.printf("Drawing circle of color %s at position (%d, %d) with radius %d\n", color, x, y, radius);
    }
}

public class DrawingApp1 {
    public static void main(String[] args) {
        Circle redCircle = new Circle("red");
        redCircle.setX(10);
        redCircle.setY(10);
        redCircle.setRadius(50);
        redCircle.draw();

        Circle blueCircle = new Circle("blue");
        blueCircle.setX(20);
        blueCircle.setY(20);
        blueCircle.setRadius(60);
        blueCircle.draw();
    }
}
