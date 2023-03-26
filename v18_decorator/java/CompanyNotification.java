package v18_decorator.java;

// Notifier interface
interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email message: " + message);
    }
}

// Decorator abstract class
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete Decorator classes
class WeChatDecorator extends NotifierDecorator {
    public WeChatDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending WeChat message: " + message);
    }
}

class MobileDecorator extends NotifierDecorator {
    public MobileDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Mobile message: " + message);
    }
}

// Client
public class CompanyNotification {
    public static void main(String[] args) {
        String message = "Hello, this is a notification!";
        
        // Sending notifications using different combinations
        Notifier notifier = new EmailNotifier();
        notifier = new WeChatDecorator(notifier);
        notifier = new MobileDecorator(notifier);
        notifier.send(message);
    }
}
