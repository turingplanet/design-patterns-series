package v8_liskov_substitution_principle.java;

public class Main5 {

    public static void main(String[] args) {
        ParentClass p = new ParentClass();
        ChildClass c = new ChildClass();
        getList(p);
        getSmallList(c);
        getList(c);
        getSmallList(p);
    }

    public static void getList(ParentClass c) {
        c.generateList();
    }
    public static void getSmallList(ChildClass c) {
        c.generateSmallList();
    }
    
}

class ParentClass {
    public void generateList() {
    }
}

class ChildClass extends ParentClass {
    public void generateSmallList() {
    }
}
