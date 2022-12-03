package v7_interface_segregation.java;

public class Game2 {

    public static void main(String[] args) {
        Monster m = new Monster();
        m.basicAttack();
        MonsterBoss b = new MonsterBoss();
        b.magicAttack();
    }
    
}

interface BasicBadCharacterSkill {
    public void basicAttack();
}

interface AdvancedBadCharacterSkill {
    public void magicAttack();
    public void recover();
}

class Monster implements BasicBadCharacterSkill {
    public void basicAttack() {
        System.out.println("Monster basic attack");
    }
}

class MonsterBoss implements BasicBadCharacterSkill, AdvancedBadCharacterSkill {
    public void basicAttack() {
        System.out.println("Boss basic attack");
    }
    public void magicAttack() {
        System.out.println("Boss magic attack");
    }
    public void recover() {
        System.out.println("Boss recover");
    };
}
