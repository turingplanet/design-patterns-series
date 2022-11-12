package v7_interface_segregation.java;

public class Game1 {

  public static void main(String[] args) {
    Monster m = new Monster();
    m.basicAttact();
    MonsterBoss b = new MonsterBoss();
    b.magicAttact();
  }

}

interface BadCharacterSkill {
  public void basicAttact();
  public void magicAttact();
  public void recover();
}

class Monster implements BadCharacterSkill {
  public void basicAttact() {
    System.out.println("Monster basic attact");
  }
  public void magicAttact() {};
  public void recover() {};
}

class MonsterBoss implements BadCharacterSkill {
  public void basicAttact() {
    System.out.println("Boss basic attact");
  }
  public void magicAttact() {
    System.out.println("Boss magic attact");
  }
  public void recover() {
    System.out.println("Boss recover");
  };
}
