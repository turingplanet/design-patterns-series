public class NotificationService1 {

    public static void main(String[] args) {
        NotificationService1 ns = new NotificationService1();
        ns.sendNotification("email", "helo");
        ns.sendNotification("message", "hello");
    }

    public void sendNotification(String serviceType, String info) {
        if (serviceType == "email") {
            sendEmail(info);
        } else if (serviceType == "message") {
            sendMessage(info);
        }
    }

    public void sendEmail(String info) {
        EmailService es = new EmailService();
        es.sendNotification(info);
    }

    public void sendMessage(String info) {
        MessageService ms = new MessageService();
        ms.sendNotification(info);
    }
}

class EmailService {
    public void sendNotification(String info) {
        System.out.printf("Email: %s\n", info);
    }
}

class MessageService {
    public void sendNotification(String info) {
        System.out.printf("Message: %s\n", info);
    }
}
