package v8_liskov_substitution_principle.java;
import java.util.ArrayList;
import java.util.List;

public class Main4 {

    
}

class ListGenerator {
    public List getList() {
        return new ArrayList<>();
    }
}

class ChildListGenerator extends ListGenerator {
    public ArrayList getList() {
        return new ArrayList<>();
    }
}

class ListGenerator2 {
    public ArrayList getList() {
        return new ArrayList<>();
    }
}

class ChildListGenerator2 extends ListGenerator2 {
    public List getList() {
        return new ArrayList<>();
    }
}
