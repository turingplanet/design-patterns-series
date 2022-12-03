package v7_interface_segregation.java;

public class Game1 {

  public static void main(String[] args) {
    Monster m = new Monster();
    m.basicAttack();
    MonsterBoss b = new MonsterBoss();
    b.magicAttack();
  }

}

interface BadCharacterSkill {
  public void basicAttack();
  public void magicAttack();
  public void recover();
}

class Monster implements BadCharacterSkill {
  public void basicAttack() {
    System.out.println("Monster basic attack");
  }
  public void magicAttack() {};
  public void recover() {};
}

class MonsterBoss implements BadCharacterSkill {
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
