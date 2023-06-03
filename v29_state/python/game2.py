class State:
    def walk(self):
        pass

    def run(self):
        pass

    def jump(self):
        pass

    def idle(self):
        pass


class IdleState(State):
    def __init__(self, character):
        self.character = character

    def walk(self):
        self.character.state = self.character.walking_state
        print("The character is now walking.")

    def run(self):
        print("The character cannot run right now.")

    def jump(self):
        print("The character cannot jump right now.")

    def idle(self):
        print("The character is already idle.")


class WalkingState(State):
    def __init__(self, character):
        self.character = character

    def walk(self):
        print("The character is already walking.")

    def run(self):
        self.character.state = self.character.running_state
        print("The character is now running.")

    def jump(self):
        print("The character cannot jump right now.")

    def idle(self):
        self.character.state = self.character.idle_state
        print("The character is now idle.")


class RunningState(State):
    def __init__(self, character):
        self.character = character

    def walk(self):
        print("The character cannot walk right now.")

    def run(self):
        print("The character is already running.")

    def jump(self):
        self.character.state = self.character.jumping_state
        print("The character is now jumping.")

    def idle(self):
        self.character.state = self.character.idle_state
        print("The character is now idle.")


class JumpingState(State):
    def __init__(self, character):
        self.character = character

    def walk(self):
        print("The character cannot walk right now.")

    def run(self):
        print("The character cannot run right now.")

    def jump(self):
        print("The character is already jumping.")

    def idle(self):
        self.character.state = self.character.idle_state
        print("The character is now idle.")


class Character:
    def __init__(self):
        self.idle_state = IdleState(self)
        self.walking_state = WalkingState(self)
        self.running_state = RunningState(self)
        self.jumping_state = JumpingState(self)

        self.state = self.idle_state

    def walk(self):
        self.state.walk()

    def run(self):
        self.state.run()

    def jump(self):
        self.state.jump()

    def idle(self):
        self.state.idle()


if __name__ == "__main__":
    character = Character()

    character.walk()  # The character is now walking.
    character.run()  # The character is now running.
    character.jump()  # The character is now jumping.
    character.idle()  # The character is now idle.

    character.run()  # The character cannot run right now.
    character.jump()  # The character cannot jump right now.


