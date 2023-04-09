class Projector:
    def on(self):
        print("Turning on the projector...")

    def off(self):
        print("Turning off the projector...")

class DVDPlayer:
    def play(self):
        print("Playing the movie...")

    def stop(self):
        print("Stopping the movie...")

class SoundSystem:
    def on(self):
        print("Turning on the sound system...")

    def off(self):
        print("Turning off the sound system...")

class HomeTheaterFacade:
    def __init__(self, projector, dvd_player, sound_system):
        self.projector = projector
        self.dvd_player = dvd_player
        self.sound_system = sound_system

    def watch_movie(self):
        self.projector.on()
        self.dvd_player.play()
        self.sound_system.on()

    def stop_movie(self):
        self.projector.off()
        self.dvd_player.stop()
        self.sound_system.off()

# Client code
projector = Projector()
dvd_player = DVDPlayer()
sound_system = SoundSystem()

home_theater = HomeTheaterFacade(projector, dvd_player, sound_system)
home_theater.watch_movie()
