package v7_interface_segregation.java;

public class Game2 {

    public static void main(String[] args) {
        Monster m = new Monster();
        m.basicAttact();
        MonsterBoss b = new MonsterBoss();
        b.magicAttact();
    }
    
}

interface BasicBadCharacterSkill {
    public void basicAttact();
}

interface AdvancedBadCharacterSkill {
    public void magicAttact();
    public void recover();
}

class Monster implements BasicBadCharacterSkill {
    public void basicAttact() {
        System.out.println("Monster basic attact");
    }
}

class MonsterBoss implements BasicBadCharacterSkill, AdvancedBadCharacterSkill {
    public void basicAttact() {
        System.out.println("Boss basic attact");
    }
    public void magicAttact() {
        System.out.println("Boss magic attach");
    }
    public void recover() {
        System.out.println("Boss recover");
    };
}
