package v10_abstract_factory.java;

public class BrandBooth {

    private Sedan sedan;
    private SUV suv;

    public static void main(String[] args) {
        BMWFactory bFactory = new BMWFactory();
        BrandBooth bmwBooth = new BrandBooth(bFactory);
        bmwBooth.showTime();

        TeslaFactory tFactory = new TeslaFactory();
        BrandBooth teslaBooth = new BrandBooth(tFactory);
        teslaBooth.showTime();
    }
    public BrandBooth(CarFactory factory) {
        this.sedan = factory.createSedan();
        this.suv = factory.createSUV();
    }
    public void showTime() {
        sedan.turnOnHeadLight();
        suv.turnOnHeadLight();
    }
}

interface Sedan {
    void turnOnHeadLight();
}
interface SUV {
    void turnOnHeadLight();
}

class BMWM5 implements Sedan {
    public void turnOnHeadLight() {
        System.out.println("BMW M5 headlight");
    }
}
class BMWX5 implements SUV {
    public void turnOnHeadLight() {
        System.out.println("BMW X5 headlight");
    }
}

class TeslaModelS implements Sedan {

    public void turnOnHeadLight() {
        System.out.println("Tesla ModelS headlight");
    }
}

class TeslaModelY implements SUV {

    public void turnOnHeadLight() {
        System.out.println("Tesla ModelY headlight");
    }
}

interface CarFactory {
    Sedan createSedan();
    SUV createSUV();
}

class BMWFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return new BMWM5();
    }
    @Override
    public SUV createSUV() {
        return new BMWX5();
    }
}


class TeslaFactory implements CarFactory{
    @Override
    public Sedan createSedan() {
        return new TeslaModelS();
    }
    @Override
    public SUV createSUV() {
        return new TeslaModelY();
    }
}
