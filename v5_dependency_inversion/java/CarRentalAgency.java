public class CarRentalAgency {

    public static void main(String[] args) {
        CarRentalAgency agency =  new CarRentalAgency();
        agency.rentCar("BMW", "X5");
        agency.rentCar("Mercedes", "GLE");
    }

    public void rentCar(String brand, String model) {
        if (brand == "BMW") {
            new BMW().rentBMW(model);
        } else if (brand == "Mercedes") {
            new Mercedes().rentMercedes(model);
        }
    }
}

class BMW {

    public void rentBMW(String model) {
        System.out.println("BMW rented " + model);
    }
}


class Mercedes {

    public void rentMercedes(String model) {
        System.out.println("Mercedes rented " + model);
    }
}
