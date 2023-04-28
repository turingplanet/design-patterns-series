package v23_command.java;

interface Light {
    void on();
    void off();
}

class LivingRoomLight implements Light {
    public void on() {
        System.out.println("Living room light is on");
    }

    public void off() {
        System.out.println("Living room light is off");
    }
}

class KitchenLight implements Light {
    public void on() {
        System.out.println("Kitchen light is on");
    }

    public void off() {
        System.out.println("Kitchen light is off");
    }
}

public class LightController1 {
    public static void main(String[] args) {
        LivingRoomLight livingRoomLight = new LivingRoomLight();
        KitchenLight kitchenLight = new KitchenLight();

        kitchenLight.on();
        kitchenLight.off();
        livingRoomLight.on();
        livingRoomLight.off();
    }
}