package v19_facade.java;

class Projector {
    public void on() {
        System.out.println("Turning on the projector...");
    }

    public void off() {
        System.out.println("Turning off the projector...");
    }
}

class DVDPlayer {
    public void play() {
        System.out.println("Playing the movie...");
    }

    public void stop() {
        System.out.println("Stopping the movie...");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Turning on the sound system...");
    }

    public void off() {
        System.out.println("Turning off the sound system...");
    }
}

public class Movie1 {
    public static void main(String[] args) {
        Projector projector = new Projector();
        DVDPlayer dvdPlayer = new DVDPlayer();
        SoundSystem soundSystem = new SoundSystem();

        projector.on();
        dvdPlayer.play();
        soundSystem.on();
    }
}
