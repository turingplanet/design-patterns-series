package v6_composite_reuse.java;

public class CarMaker {

    public static void main(String[] args) {
        RedGasolineCar c1 = new RedGasolineCar();
        c1.move();
    }

}

class GasolineCar {
    public void move() {
        System.out.println("gasoline move");

    };
}

class ElectricCar {
    public void move() {
        System.out.println("electric move");
    }
}

class RedGasolineCar extends GasolineCar {
    public void move() {
        System.out.println("red gasoline move");
    }
}

class BlueGasolineCar extends GasolineCar {
    public void move() {
        System.out.println("blue gasoline move");
    }
}

