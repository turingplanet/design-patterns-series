class Character:
    def __init__(self):
        self.state = "idle"

    def walk(self):
        if self.state == "idle":
            self.state = "walking"
            print("The character is now walking.")
        else:
            print("The character cannot walk right now.")

    def run(self):
        if self.state == "walking":
            self.state = "running"
            print("The character is now running.")
        else:
            print("The character cannot run right now.")

    def jump(self):
        if self.state == "running":
            self.state = "jumping"
            print("The character is now jumping.")
        else:
            print("The character cannot jump right now.")

    def idle(self):
        self.state = "idle"
        print("The character is now idle.")


if __name__ == "__main__":
    character = Character()

    character.walk()  # The character is now walking.
    character.run()  # The character is now running.
    character.jump()  # The character is now jumping.
    character.idle()  # The character is now idle.

    character.run()  # The character cannot run right now.
    character.jump()  # The character cannot jump right now.


