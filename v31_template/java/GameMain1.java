package v31_template.java;

class Chess {

    public void initializeGame() {
        System.out.println("Initializing Chess Game");
    }

    public void playGame() {
        System.out.println("Playing Chess Game");
    }

    public void endGame() {
        System.out.println("Ending Chess Game");
    }

    public void play() {
        initializeGame();
        playGame();
        endGame();
    }
}

class Football {

    public void initializeGame() {
        System.out.println("Initializing Football Game");
    }

    public void playGame() {
        System.out.println("Playing Football Game");
    }

    public void endGame() {
        System.out.println("Ending Football Game");
    }

    public void play() {
        initializeGame();
        playGame();
        endGame();
    }
}

public class GameMain1 {
    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.play();

        Football football = new Football();
        football.play();
    }
}
