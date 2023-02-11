package v13_prototype.java;
import java.util.Hashtable;
import java.util.Objects;

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

    public String getModel() {
        return this.model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacketPrototype that = (RacketPrototype) o;
        return Double.compare(that.weight, weight) == 0 &&
               Double.compare(that.balancePoint, balancePoint) == 0 &&
               brand.equals(that.brand) &&
               model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, weight, balancePoint);
    }
}

class WilsonTennisRacket extends RacketPrototype {

    public WilsonTennisRacket(String brand, String model, double weight, double balancePoint) {
        super("Wilson", "Pro Staff", 320.0, 32.5);
    }

    @Override
    public RacketPrototype clone() {
        return new WilsonTennisRacket(brand, model, weight, balancePoint);
    }
}

class TennisRacketStorage {

    private static Hashtable<String, RacketPrototype> racketMap;

    public static RacketPrototype getClonedRacket(String model) {
        RacketPrototype r = racketMap.get(model);
        return (RacketPrototype) r.clone();
    }

    public static void buildProtypes() {
        WilsonTennisRacket r1 = new WilsonTennisRacket("Wilson", "Pro Staff", 320.0, 32.5);
        racketMap.put(r1.getModel(), r1);
    }
}

class TennisPlayer {

    public static void main(String[] args) {
        TennisRacketStorage.buildProtypes();
        for (int i = 0; i < 10; i++) {
            TennisRacketStorage.getClonedRacket("Pro Staff");
        }
    }

}

