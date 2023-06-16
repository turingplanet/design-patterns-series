package v31_template.java;

abstract class House {
    final void buildHouse() {
        buildFoundation();
        buildWalls();
        buildWindows();
        buildRoof();
        if (isLandscapingNeeded()) {
            landscape();
        }
    }

    void buildFoundation() { System.out.println("Building basic foundation."); }

    abstract void buildWalls();

    abstract void buildWindows();

    abstract void buildRoof();

    boolean isLandscapingNeeded() { return true; }

    void landscape() { System.out.println("Landscaping the surroundings."); }
}

class ConcreteHouse extends House {
    void buildWalls() { System.out.println("Building concrete walls."); }

    void buildWindows() { System.out.println("Building concrete windows."); }

    void buildRoof() { System.out.println("Building concrete roof."); }

    boolean isLandscapingNeeded() { return false; }
}

class WoodenHouse extends House {
    void buildWalls() { System.out.println("Building wooden walls."); }

    void buildWindows() { System.out.println("Building wooden windows."); }

    void buildRoof() { System.out.println("Building wooden roof."); }
}

public class HouseBuilder {
    public static void main(String[] args) {
        House concreteHouse = new ConcreteHouse();
        concreteHouse.buildHouse();
        System.out.println("-------------------------------");
        House woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();
    }
}

