package v13_prototype.java;
import java.util.Hashtable;

abstract class RacketPrototype {
    protected String brand;
    protected String model;
    protected double weight;
    protected double balancePoint;

    public RacketPrototype(String brand, String model, double weight, double balancePoint) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.balancePoint = balancePoint;
    }

    public abstract RacketPrototype clone();
}

class WilsonTennisRacket extends RacketPrototype {

    public WilsonTennisRacket(String brand, String model, double weight, double balancePoint) {
        super(brand, model, weight, balancePoint);
    }

    @Override
    public RacketPrototype clone() {
        System.out.printf("Wilson clone: %s %s %s %s\n", this.brand, this.model, this.weight, this.balancePoint);
        return new WilsonTennisRacket(this.brand, this.model, this.weight, this.balancePoint);
    }
}

 class HeadTennisRacket extends RacketPrototype {

    public HeadTennisRacket(String brand, String model, double weight, double balancePoint) {
        super(brand, model, weight, balancePoint);
    }

    @Override
    public RacketPrototype clone() {
        System.out.printf("Head clone: %s %s %s %s\n", this.brand, this.model, this.weight, this.balancePoint);
        return new WilsonTennisRacket(this.brand, this.model, this.weight, this.balancePoint);
    }
 }

class TennisRacketPrototypeManager {

    private static Hashtable<String, RacketPrototype> racketMap = new Hashtable<String, RacketPrototype>();

    public static RacketPrototype getClonedRacket(String model) {
        RacketPrototype r = racketMap.get(model);
        return (RacketPrototype) r.clone();
    }

    public static void buildProtypes() {
        WilsonTennisRacket r1 = new WilsonTennisRacket("Wilson", "Pro Staff", 320.0, 32.5);
        racketMap.put("pro staff", r1);
        HeadTennisRacket h1 = new HeadTennisRacket("Head", "Graphene 360 Speed", 320.0, 32.5);
        racketMap.put("graphene 360" , h1);
    }
}

public class TennisPlayer {

    public static void main(String[] args) {
        TennisRacketPrototypeManager.buildProtypes();
        for (int i = 0; i < 10; i++) {
            TennisRacketPrototypeManager.getClonedRacket("pro staff");
        }
    }

}


