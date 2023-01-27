package v11_builder.java;

class Milktea {

    double price;
    String topping = "boba";
    String tea = "regularMilktea";
    Integer suger = 100;

    public Milktea() {
        this.price = 7.0;
    }

    public double getPrice() {
        return this.price;
    }

}

class SignatureMilktea extends Milktea {
    public SignatureMilktea() {
        this.price = 5.7;
    }
}

class OolongMilktea extends Milktea {
    public OolongMilktea() {
        this.price = 4.5;
    }
}

interface MilkteaBuilder {
    void reset();
    void addTopping();
    void addTea();
    void addSugerLevel();
    Milktea getProduct();

}

class SignatureMilkteaBuilder implements MilkteaBuilder {
    private SignatureMilktea product;
    public void reset() {
        this.product = new SignatureMilktea();
    }
    public void addTopping() {
        product.topping = "boba";
    }
    public void addTea() {
        product.tea = "signature tea";
    }
    public void addSugerLevel() {
        product.suger = 100;
    }
    public Milktea getProduct() {
        System.out.format("Signature milktea: %s %s %s\n", this.product.topping, this.product.tea, this.product.suger);
        return this.product;
    }
}

class OolongMilkteaBuilder implements MilkteaBuilder {

    private OolongMilktea product;

    public void reset() {
        this.product = new OolongMilktea();
    }
    public void addTopping() {
        product.topping = "grass jelly";
    }
    public void addTea() {
        product.tea = "oolong";
    }
    public void addSugerLevel() {
        product.suger = 50;
    }
    public  Milktea getProduct() {
        System.out.format("Oolong milktea: %s %s %s\n", this.product.topping, this.product.tea, this.product.suger);
        return this.product;
    }
}

class CustomizedMilkteaBuilder {
    private Milktea product;
    public void reset() {
        this.product = new Milktea();
    }
    public void addTopping(String boba) {
        product.topping = boba;
    }
    public void addTea(String tea) {
        product.tea = tea;
    }
    public void addSugerLevel(Integer sugar) {
        product.suger = sugar;
    }
    public Milktea getProduct() {
        System.out.format("Customized milktea: %s %s %s\n", this.product.topping, this.product.tea, this.product.suger);
        return this.product;
    }
}

class MilkteaDirector {
    private MilkteaBuilder milkteaBuilder;

    public MilkteaDirector(MilkteaBuilder builder) {
        this.milkteaBuilder = builder;
    }

    public void changeBuilder(MilkteaBuilder builder) {
        this.milkteaBuilder = builder;
    }

    public Milktea makeMiketea() {
        this.milkteaBuilder.reset();
        this.milkteaBuilder.addTopping();;
        this.milkteaBuilder.addTea();
        this.milkteaBuilder.addSugerLevel();
        return this.milkteaBuilder.getProduct();
    }

    public Milktea make(String type) {
        if (type == "signature") {
            this.changeBuilder(new SignatureMilkteaBuilder());
        } else if (type == "oolong") {
            this.changeBuilder(new OolongMilkteaBuilder());

        }
        return this.makeMiketea();
    }
}

public class TuringBobaShop {

    public static void main(String[] args) {
        MilkteaDirector director = new MilkteaDirector(new SignatureMilkteaBuilder());
        director.makeMiketea();
        director.changeBuilder(new OolongMilkteaBuilder());
        director.makeMiketea();
        director.make("signature");
        director.make("oolong");

        CustomizedMilkteaBuilder builder = new CustomizedMilkteaBuilder();
        builder.reset();
        builder.addTopping("boba");
        builder.addTea("Oolong");
        builder.addSugerLevel(10);
        builder.getProduct();
    }
    
}
