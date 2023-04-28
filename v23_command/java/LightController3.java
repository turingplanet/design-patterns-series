package v23_command.java;
import java.util.List;
import java.util.Arrays;


interface Light {
    void on();
    void off();
    void increaseBrightness();
}

class KitchenLight implements Light {
    public void on() {
        System.out.println("Kitchen light is on");
    }

    public void off() {
        System.out.println("Kitchen light is off");
    }

    public void increaseBrightness() {
        System.out.println("Kitchen light brightness increased");
    }
}

class LivingRoomLight implements Light {
    public void on() {
        System.out.println("Living room light is on");
    }

    public void off() {
        System.out.println("Living room light is off");
    }

    public void increaseBrightness() {
        System.out.println("Living room light brightness increased");
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

class LightIncreaseCommand implements Command {
    private Light light;

    public LightIncreaseCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.increaseBrightness();
    }

    public void undo() {
        // Implement an appropriate undo operation, such as decreasing brightness
        System.out.println("TODO");
    }
}

class Fan {
    public void on() {
        System.out.println("Fan is on");
    }

    public void off() {
        System.out.println("Fan is off");
    }
}

class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        fan.off();
    }
}

class AllLightsOffCommand implements Command {
    private List<Light> lights;

    public AllLightsOffCommand(List<Light> lights) {
        this.lights = lights;
    }

    public void execute() {
        for (Light light : lights) {
            light.off();
        }
    }

    public void undo() {
        for (Light light : lights) {
            light.on();
        }
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

public class LightController3 {
    public static void main(String[] args) {
        LivingRoomLight livingRoomLight = new LivingRoomLight();
        KitchenLight kitchenLight = new KitchenLight();
        Fan fan = new Fan();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        LightIncreaseCommand kitchenLightIncrease = new LightIncreaseCommand(kitchenLight);
        FanOnCommand fanOn = new FanOnCommand(fan);
        AllLightsOffCommand allLightsOff = new AllLightsOffCommand(Arrays.asList(livingRoomLight, kitchenLight));

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingRoomLightOn);
        remote.pressButton(); // Living room light is on
        remote.pressUndo();   // Living room light is off

        remote.setCommand(kitchenLightOff);
        remote.pressButton(); // Kitchen light is off
        remote.pressUndo();   // Kitchen light is on

        remote.setCommand(kitchenLightIncrease);
        remote.pressButton(); // Increase kitchen light brightness

        remote.setCommand(fanOn);
        remote.pressButton(); 

        remote.setCommand(allLightsOff);
        remote.pressButton(); 
    }
}
