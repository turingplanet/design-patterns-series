package v8_liskov_substitution_principle.java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main3 {

    public static ArrayList<String> stringToList(Calculator c, String s) {
        return c.stringToList(s);
    }

}

abstract class Calculator {
    public abstract ArrayList<String> stringToList(String s);
}

class SuperCalculator extends Calculator {
    public List<String> stringToList(String s) {
        // do something
    }
}
