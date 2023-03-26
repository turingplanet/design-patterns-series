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

# Client code
projector = Projector()
dvd_player = DVDPlayer()
sound_system = SoundSystem()

projector.on()
dvd_player.play()
sound_system.on()

