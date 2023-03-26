package v19_facade.java;


public class Movie2 {
    
}

class HomeTheaterFacade {
    private Projector projector;
    private DVDPlayer dvdPlayer;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(Projector projector, DVDPlayer dvdPlayer, SoundSystem soundSystem) {
        this.projector = projector;
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
    }

    public void watchMovie() {
        projector.on();
        dvdPlayer.play();
        soundSystem.on();
    }

    public void stopMovie() {
        projector.off();
        dvdPlayer.stop();
        soundSystem.off();
    }
}

public class Main {
    public static void main(String[] args) {
        Projector projector = new Projector();
        DVDPlayer dvdPlayer = new DVDPlayer();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, dvdPlayer, soundSystem);
        homeTheater.watchMovie();
    }
}
