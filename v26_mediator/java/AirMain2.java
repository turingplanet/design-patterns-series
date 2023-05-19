package v26_mediator.java;

import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void send(String message, Airplane sender);
}

class Airplane {
    private String name;
    private Mediator mediator;

    public Airplane(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message) {
        System.out.println(this.name + " sends message: " + message);
        mediator.send(message, this);
    }

    public void receive(String message) {
        System.out.println(this.name + " receives message: " + message);
    }

    public String getName() {
        return this.name;
    }
}

class AirTrafficControl implements Mediator {
    private List<Airplane> airplanes;

    public AirTrafficControl() {
        this.airplanes = new ArrayList<>();
    }

    public void registerAirplane(Airplane airplane) {
        this.airplanes.add(airplane);
    }

    public void send(String message, Airplane sender) {
        for (Airplane airplane : airplanes) {
            if (airplane != sender) {
                airplane.receive(message);
            }
        }
    }
}

public class AirMain2 {
    public static void main(String[] args) {
        AirTrafficControl atc = new AirTrafficControl();

        Airplane airplane1 = new Airplane("Airplane1", atc);
        Airplane airplane2 = new Airplane("Airplane2", atc);
        Airplane airplane3 = new Airplane("Airplane3", atc);

        atc.registerAirplane(airplane1);
        atc.registerAirplane(airplane2);
        atc.registerAirplane(airplane3);

        airplane1.send("Hello, everyone!");
        airplane2.send("Hello, everyone!");
        airplane3.send("Hello, everyone!");
    }
}
