package v23_command.java;


interface Light {
    void on();
    void off();
}

class KitchenLight implements Light {
    public void on() {
        System.out.println("Kitchen light is on");
    }

    public void off() {
        System.out.println("Kitchen light is off");
    }
}

class LivingRoomLight implements Light {
    public void on() {
        System.out.println("Living room light is on");
    }

    public void off() {
        System.out.println("Living room light is off");
    }
}

interface Command {
    void execute();
    void undo();
}


class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}

public class LightController2 {
    public static void main(String[] args) {
        LivingRoomLight livingRoomLight = new LivingRoomLight();
        KitchenLight kitchenLight = new KitchenLight();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingRoomLightOn);
        remote.pressButton(); // Living room light is on
        remote.pressUndo();   // Living room light is off

        remote.setCommand(kitchenLightOff);
        remote.pressButton(); // Kitchen light is off
        remote.pressUndo();   // Kitchen light is on
    }
}
