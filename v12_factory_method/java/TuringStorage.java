package v12_factory_method.java;

interface Car {
    Boolean startEngine();
    void turnOffEngine();
}

class ModelA implements Car {
    public Boolean startEngine() {
        System.out.println("modelA startEngine");
        return true;
    }
    public void turnOffEngine() {
        System.out.println("modelA turnOffEngine");
    }
}

class ModelB implements Car {
    public Boolean startEngine() {
        System.out.println("modelB startEngine");
        return true;
    }
    public void turnOffEngine() {
        System.out.println("modelB startEngine");
    }
}

interface CarFactory {
    Car makeCar();
}


class ModelAFactory implements CarFactory {
    public Car makeCar() {
        Car modelA = new ModelA();
        if (modelA.startEngine() == true) {
            modelA.turnOffEngine();
            return modelA;
        } else {
            return null;
        }
    }
}

class ModelBFactory implements CarFactory {
    public Car makeCar() {
        Car modelB = new ModelB();
        if (modelB.startEngine() == true) {
            modelB.turnOffEngine();
            return modelB;
        } else {
            return null;
        }
    }
}

public class TuringStorage {

    Car[] carStorage = new Car[10];

    public void importCars() {
        ModelAFactory factoryA = new ModelAFactory();
        ModelBFactory factoryB = new ModelBFactory();
        for (int i = 0; i < 5; i ++) {
            this.carStorage[i] =factoryA.makeCar();
        }
        for (int i = 5; i < 10; i ++) {
            this.carStorage[i] =factoryB.makeCar();
        }

    }

    public static void main(String[] args) {
        TuringStorage storage = new TuringStorage();
        storage.importCars();
    }

}