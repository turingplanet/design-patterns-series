package v20_flyweight.java;

import java.util.HashMap;
import java.util.Map;

interface Shape {
    void draw(int x, int y, int radius);
}

class CircleFlyweight implements Shape {
    private String color;

    public CircleFlyweight(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y, int radius) {
        System.out.printf("Drawing circle of color %s at position (%d, %d) with radius %d\n", color, x, y, radius);
    }
}

class ShapeFactory {
    private static final Map<String, CircleFlyweight> circleMap = new HashMap<>();

    public static CircleFlyweight getCircle(String color) {
        CircleFlyweight circle = circleMap.get(color);
        
        if (circle == null) {
            circle = new CircleFlyweight(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        
        return circle;
    }
}

public class DrawingApp2 {
    public static void main(String[] args) {
        CircleFlyweight redCircle = ShapeFactory.getCircle("red");
        redCircle.draw(10, 10, 50);

        CircleFlyweight blueCircle = ShapeFactory.getCircle("blue");
        blueCircle.draw(20, 20, 60);

        CircleFlyweight anotherRedCircle = ShapeFactory.getCircle("red");
        anotherRedCircle.draw(30, 30, 40);
    }
}
