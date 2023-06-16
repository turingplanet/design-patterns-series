package v31_template.java;

abstract class Game {

    public abstract void initializeGame();

    public abstract void playGame();

    public abstract void endGame();

    // Template method
    public final void play() {
        initializeGame();
        playGame();
        endGame();
    }
}

class Chess extends Game {

    @Override
    public void initializeGame() {
        System.out.println("Initializing Chess Game");
    }

    @Override
    public void playGame() {
        System.out.println("Playing Chess Game");
    }

    @Override
    public void endGame() {
        System.out.println("Ending Chess Game");
    }
}

class Football extends Game {

    @Override
    public void initializeGame() {
        System.out.println("Initializing Football Game");
    }

    @Override
    public void playGame() {
        System.out.println("Playing Football Game");
    }

    @Override
    public void endGame() {
        System.out.println("Ending Football Game");
    }
}

public class GameMain2 {
    public static void main(String[] args) {
        Game chess = new Chess();
        chess.play();

        Game football = new Football();
        football.play();
    }
}
