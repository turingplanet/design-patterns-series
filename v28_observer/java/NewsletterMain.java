package v28_observer.java;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Reader implements Observer {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to " + name + ": " + message);
    }
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class NewsletterPublisher implements Subject {
    private List<Observer> readers;
    private String latestNewsletter;

    public NewsletterPublisher() {
        readers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        readers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        readers.remove(observer);
    }

    public void publish(String newsletter) {
        this.latestNewsletter = newsletter;
        notifyObservers();
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : readers) {
            observer.update(latestNewsletter);
        }
    }
}

public class NewsletterMain {
    
    public static void main(String[] args) {
        NewsletterPublisher publisher = new NewsletterPublisher();

        Reader alice = new Reader("Alice");
        Reader bob = new Reader("Bob");
        Reader charlie = new Reader("Charlie");

        publisher.registerObserver(alice);
        publisher.registerObserver(bob);

        publisher.publish("New edition of the newsletter is out!");

        publisher.registerObserver(charlie);
        publisher.removeObserver(alice);

        publisher.publish("Another edition of the newsletter is here!");
    }

}
