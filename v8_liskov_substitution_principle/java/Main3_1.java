package v8_liskov_substitution_principle.java;
import java.util.ArrayList;
import java.util.List;

public class Main3_1 {

    public static void main(String[] args) {
        ArrayList l1 = new ArrayList<>();
        ListGenerator lg = new ListGenerator();
        lg.processList(l1);
        ListGenerator2 lg2 = new ListGenerator2();
        lg2.processList(l1);
    }

}

class AutoFactory {
    public List assembleAutomotives(List list) {
        return list;
    }
}

class SmallAutoFactory extends ListGenerator {
    public ArrayList generList(ArrayList list) {
        return list;
    }
}
