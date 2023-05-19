package v26_mediator.java;

class Airplane {
    private String name;

    public Airplane(String name) {
        this.name = name;
    }

    public void send(String message, Airplane receiver) {
        System.out.println(this.name + " sends message to " + receiver.getName() + ": " + message);
        receiver.receive(message, this);
    }

    public void receive(String message, Airplane sender) {
        System.out.println(this.name + " receives message from " + sender.getName() + ": " + message);
    }

    public String getName() {
        return this.name;
    }
}

public class AirMain1 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("Airplane1");
        Airplane airplane2 = new Airplane("Airplane2");
        Airplane airplane3 = new Airplane("Airplane3");

        airplane1.send("Hello, Airplane2!", airplane2);
        airplane2.send("Hello, Airplane3!", airplane3);
        airplane3.send("Hello, Airplane1!", airplane1);
    }
}
