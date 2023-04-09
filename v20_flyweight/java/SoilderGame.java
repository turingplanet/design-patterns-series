package v20_flyweight.java;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface SoldierFlyweight {
    void display(int x, int y);
}

// Concrete Flyweight class
class SoldierType implements SoldierFlyweight {
    private String type;
    private String weapon;
    private String armor;

    public SoldierType(String type, String weapon, String armor) {
        this.type = type;
        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying " + type + " at (" + x + ", " + y + ") with weapon " + weapon + " and armor " + armor);
    }
}

class SoldierFlyweightFactory {
    private Map<String, SoldierFlyweight> soldierTypeMap = new HashMap<>();

    public SoldierFlyweight getSoldierType(String type, String weapon, String armor) {
        SoldierFlyweight soldierType = soldierTypeMap.get(type);
        if (soldierType == null) {
            soldierType = new SoldierType(type, weapon, armor);
            soldierTypeMap.put(type, soldierType);
        }
        return soldierType;
    }
}

class Soldier {
    private SoldierFlyweight soldierFlyweight;
    private int x;
    private int y;

    public Soldier(SoldierFlyweight soldierFlyweight, int x, int y) {
        this.soldierFlyweight = soldierFlyweight;
        this.x = x;
        this.y = y;
    }

    public void display() {
        soldierFlyweight.display(x, y);
    }
}

// Client
public class SoilderGame {
    public static void main(String[] args) {
        SoldierFlyweightFactory soldierTypeFactory = new SoldierFlyweightFactory();

        // Create soldier types using the factory
        SoldierFlyweight archerType = soldierTypeFactory.getSoldierType("Archer", "Bow", "Leather");
        SoldierFlyweight knightType = soldierTypeFactory.getSoldierType("Knight", "Sword", "Plate");

        // Create soldiers of different types
        Soldier archer1 = new Soldier(archerType, 100, 50);
        Soldier archer2 = new Soldier(archerType, 120, 60);
        Soldier knight1 = new Soldier(knightType, 200, 100);
        Soldier knight2 = new Soldier(knightType, 250, 120);

        // Display soldiers
        archer1.display();
        archer2.display();
        knight1.display();
        knight2.display();
    }
}
