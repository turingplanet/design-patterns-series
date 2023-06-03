package v29_state.java;

class Character {
    private String state = "idle";

    public void walk() {
        if (state.equals("idle")) {
            state = "walking";
            System.out.println("The character is now walking.");
        } else {
            System.out.println("The character cannot walk right now.");
        }
    }

    public void run() {
        if (state.equals("walking")) {
            state = "running";
            System.out.println("The character is now running.");
        } else {
            System.out.println("The character cannot run right now.");
        }
    }

    public void jump() {
        if (state.equals("running")) {
            state = "jumping";
            System.out.println("The character is now jumping.");
        } else {
            System.out.println("The character cannot jump right now.");
        }
    }

    public void idle() {
        state = "idle";
        System.out.println("The character is now idle.");
    }
}

public class Game1 {
    public static void main(String[] args) {
        Character character = new Character();

        character.walk(); // The character is now walking.
        character.run(); // The character is now running.
        character.jump(); // The character is now jumping.
        character.idle(); // The character is now idle.

        character.run(); // The character cannot run right now.
        character.jump(); // The character cannot jump right now.
    }
}
