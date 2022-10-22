public class CarBuilder {

    public static void main(String[] args) {
        CarBuilder carBuilder =  new CarBuilder();
        carBuilder.buildCar("BMW", "X5");
        carBuilder.buildCar("Mercedes", "GLE");
    }

    public void buildCar(String brand, String model) {
        if (brand == "BMW") {
            new BMW().buildBMW(model);
        } else if (brand == "Mercedes") {
            new Mercedes().buildMercedes(model);
        }
    }
}

class BMW {

    public void buildBMW(String model) {
        System.out.println("BMW built " + model);
    }
}


class Mercedes {

    public void buildMercedes(String model) {
        System.out.println("Mercedes built " + model);
    }
}
