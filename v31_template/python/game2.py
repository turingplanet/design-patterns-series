from abc import ABC, abstractmethod

class Game(ABC):

    @abstractmethod
    def initialize_game(self):
        pass

    @abstractmethod
    def play_game(self):
        pass

    @abstractmethod
    def end_game(self):
        pass

    # Template method
    def play(self):
        self.initialize_game()
        self.play_game()
        self.end_game()


class Chess(Game):

    def initialize_game(self):
        print("Initializing Chess Game")

    def play_game(self):
        print("Playing Chess Game")

    def end_game(self):
        print("Ending Chess Game")


class Football(Game):

    def initialize_game(self):
        print("Initializing Football Game")

    def play_game(self):
        print("Playing Football Game")

    def end_game(self):
        print("Ending Football Game")


def main():
    chess = Chess()
    chess.play()

    football = Football()
    football.play()


if __name__ == "__main__":
    main()


