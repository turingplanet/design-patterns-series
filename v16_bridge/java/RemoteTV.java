package v16_bridge.java;

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void powerOn();

    public abstract void powerOff();

    public abstract void volumeUp();

    public abstract void volumeDown();
}

interface Device {
    void powerOn();

    void powerOff();

    void setVolume(int volume);

    int getVolume();
}

class TV implements Device {
    private int volume = 50;

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
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
        System.out.println("TV volume set to " + this.volume);
    }

    @Override
    public int getVolume() {
        return volume;
    }
}

class DVDPlayer implements Device {
    private int volume = 50;

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
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
        System.out.println("DVD player volume set to " + this.volume);
    }

    @Override
    public int getVolume() {
        return volume;
    }
}

class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.print("Basic Remote: power on -> ");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.print("Basic Remote: power off -> ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.print("Advanced Remote: power on -> ");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.print("Advanced Remote: power off -> ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 5);
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 5);
    }
}

public class RemoteTV {

    public static void main(String[] args) {
        Device tv = new TV();
        Device dvdPlayer = new DVDPlayer();

        RemoteControl basicRemote = new BasicRemote(tv);
        basicRemote.powerOn();
        basicRemote.powerOff();
        basicRemote.volumeUp();
        basicRemote.volumeDown();

        RemoteControl advancedRemote = new AdvancedRemote(dvdPlayer);
        advancedRemote.powerOn();
        advancedRemote.powerOff();
        advancedRemote.volumeUp();
        advancedRemote.volumeDown();

        basicRemote = new BasicRemote(dvdPlayer);
        basicRemote.powerOn();
        basicRemote.powerOff();
        basicRemote.volumeUp();
        basicRemote.volumeDown();
    }
}
