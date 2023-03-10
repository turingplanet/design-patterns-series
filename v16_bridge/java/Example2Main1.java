package v16_bridge.java;

public class Main {

}

public abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void powerOn();
    public abstract void powerOff();
    public abstract void volumeUp();
    public abstract void volumeDown();
}

public interface Device {
    void powerOn();
    void powerOff();
    void setVolume(int volume);
}


public class TV implements Device {
    @Override
    public void powerOn() {
        System.out.println("TV is on.");
    }

    @Override
    public void powerOff() {
        System.out.println("TV is off.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

public class DVDPlayer implements Device {
    @Override
    public void powerOn() {
        System.out.println("DVD player is on.");
    }

    @Override
    public void powerOff() {
        System.out.println("DVD player is off.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("DVD player volume set to " + volume);
    }
}

public class Stereo implements Device {
    @Override
    public void powerOn() {
        System.out.println("Stereo is on.");
    }

    @Override
    public void powerOff() {
        System.out.println("Stereo is off.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Stereo volume set to " + volume);
    }
}



public class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.print("Remote: power on -> ");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.print("Remote: power off -> ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.print("Remote: volume up -> ");
        int volume = getVolume() + 10;
        device.setVolume(volume);
    }

    @Override
    public void volumeDown() {
        System.out.print("Remote: volume down -> ");
        int volume = getVolume() - 10;
        device.setVolume(volume);
    }

    private int getVolume() {
        return ((DeviceWithVolume) device).getVolume();
    }
}

public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.print("Remote: power on -> ");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.print("Remote: power off -> ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.print
