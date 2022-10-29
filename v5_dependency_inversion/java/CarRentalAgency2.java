public class CarRentalAgency2 {

    public static void main(String[] args) {
        CarRentalAgency2 agency = new CarRentalAgency2();
        agency.rentCar(new BMW(), "X5");
        agency.rentCar(new Mercedes(), "GLE");
        agency.rentCar(new Honda(), "Accord");
    }

    public void rentCar(CarManufactory cm, String mode) {
        cm.rent(mode);
    }
    
}

interface CarManufactory {
    public void rent(String model);
}

class BMW implements CarManufactory {
    
    public void rent(String model) {
        System.out.println("BMW rented " + model);
    }
}

class Mercedes implements CarManufactory{

    public void rent(String model) {
        System.out.println("Mercedes rented " + model);
    }
}

class Honda implements CarManufactory {

    public void rent(String model) {
        System.out.println("Honde rented " + model);
    }
}
