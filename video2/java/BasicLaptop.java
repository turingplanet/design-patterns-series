public class BasicLaptop implements Laptop {

    String cpu = "";
    int size = 0;

    public static void main(String args[]) {
      System.out.println("Hello");
    }

    public void startUp() {};
    public void shutDown() {};
}

interface Laptop {
    String cpu = "";
    int size = 0;
    void startUp();
    void shutDown();
}
