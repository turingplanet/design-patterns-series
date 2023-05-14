package v26_mediator.java;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}


class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            // message should not be received by the user sending it
            if (u != user) {
                u.receive(msg);
            }
        }
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name){
        this.mediator=med;
        this.name=name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}

class UserImpl extends User {
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg){
        System.out.println(this.name + " is sending message: " + msg);
        mediator.sendMessage(msg, this);
    }
    @Override
    public void receive(String msg) {
        System.out.println(this.name + " received message: " + msg);
    }
}

public class ChatRoomMain {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();

        User user1 = new UserImpl(mediator, "User1");
        User user2 = new UserImpl(mediator, "User2");
        User user3 = new UserImpl(mediator, "User3");
        User user4 = new UserImpl(mediator, "User4");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hello, World!");
    }
}

