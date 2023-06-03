package v29_state.java;

interface State {
    void walk();
    void run();
    void jump();
    void idle();
}

class IdleState implements State {
    private Character character;

    public IdleState(Character character) {
        this.character = character;
    }

    public void walk() {
        character.setState(character.getWalkingState());
        System.out.println("The character is now walking.");
    }

    public void run() {
        System.out.println("The character cannot run right now.");
    }

    public void jump() {
        System.out.println("The character cannot jump right now.");
    }

    public void idle() {
        System.out.println("The character is already idle.");
    }
}

class WalkingState implements State {
    private Character character;

    public WalkingState(Character character) {
        this.character = character;
    }

    public void walk() {
        System.out.println("The character is already walking.");
    }

    public void run() {
        character.setState(character.getRunningState());
        System.out.println("The character is now running.");
    }

    public void jump() {
        System.out.println("The character cannot jump right now.");
    }

    public void idle() {
        character.setState(character.getIdleState());
        System.out.println("The character is now idle.");
    }
}

class RunningState implements State {
    private Character character;

    public RunningState(Character character) {
        this.character = character;
    }

    public void walk() {
        System.out.println("The character cannot walk right now.");
    }

    public void run() {
        System.out.println("The character is already running.");
    }

    public void jump() {
        character.setState(character.getJumpingState());
        System.out.println("The character is now jumping.");
    }

    public void idle() {
        character.setState(character.getIdleState());
        System.out.println("The character is now idle.");
    }
}

class JumpingState implements State {
    private Character character;

    public JumpingState(Character character) {
        this.character = character;
    }

    public void walk() {
        System.out.println("The character cannot walk right now.");
    }

    public void run() {
        System.out.println("The character cannot run right now.");
    }

    public void jump() {
        System.out.println("The character is already jumping.");
    }

    public void idle() {
        character.setState(character.getIdleState());
        System.out.println("The character is now idle.");
    }
}

class Character {
    private State idleState;
    private State walkingState;
    private State runningState;
    private State jumpingState;

    private State state;

    public Character() {
        idleState = new IdleState(this);
        walkingState = new WalkingState(this);
        runningState = new RunningState(this);
        jumpingState = new JumpingState(this);

        state = idleState;
    }

    public void walk() {
        state.walk();
    }

    public void run() {
        state.run();
    }

    public void jump() {
        state.jump();
    }

    public void idle() {
        state.idle();
    }

    public void setState(State state) {
        this.state = state;
    }

    // Getter methods for the states
    public State getIdleState() {
        return idleState;
    }

    public State getWalkingState() {
        return walkingState;
    }

    public State getRunningState() {
        return runningState;
    }

    public State getJumpingState() {
        return jumpingState;
    }
}


public class Game2 {
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
