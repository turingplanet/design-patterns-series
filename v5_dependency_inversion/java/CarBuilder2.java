public class CarBuilder2 {

    public static void main(String[] args) {
        CarBuilder2 cb = new CarBuilder2();
        cb.buildCar(new BMW(), "X5");
        cb.buildCar(new Mercedes(), "GLE");
        cb.buildCar(new Honda(), "Accord");
    }

    public void buildCar(CarManufactory cm, String mode) {
        cm.build(mode);
    }
    
}

interface CarManufactory {
    public void build(String model);
}

class BMW implements CarManufactory {
    
    public void build(String model) {
        System.out.println("BMW built " + model);
    }
}

class Mercedes implements CarManufactory{

    public void build(String model) {
        System.out.println("Mercedes built " + model);
    }
}

class Honda implements CarManufactory {

    public void build(String model) {
        System.out.println("Honde built " + model);
    }
}
