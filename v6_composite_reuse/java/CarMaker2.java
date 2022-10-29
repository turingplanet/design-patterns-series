package v6_composite_reuse.java;

public class CarMaker2 {

    public static void main(String[] args) {
        Car c = new Car(new Gasoline(), new Blue());
        c.move();
    }
    
}

class Car {
    private Energy energy;
    private Color color;
    public Car(Energy e, Color c) {
        this.energy = e;
        this.color = c;
    }
    public void move() {
        System.out.println(energy.toString() + color.toString() + "move");
    }
}

interface Energy {}

class Gasoline implements Energy { 
    public String toString() {return "gasoline";}
}

class Electric implements Energy { 
    public String toString() {return "electric";}
}

interface Color {}

class Red implements Color {
    public String toString() {return "red";}
}

class Blue implements Color {
    public String toString() {return "blue";}
}

