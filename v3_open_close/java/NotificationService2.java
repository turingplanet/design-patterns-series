public class NotificationService2 {

    public static void main(String[] args) {
        NotificationService2 ns = new NotificationService2();
        ns.sendNotification(new EmailService(), "helo");
        ns.sendNotification(new MessageService(), "hello");
        ns.sendNotification(new WechatService(), "hello");
    }

    public void sendNotification(NotificationService ns, String info) {
        ns.sendNotification(info);
    }
}

interface NotificationService {
    public void sendNotification(String info);
}

class EmailService implements NotificationService {
    public void sendNotification(String info) {
        System.out.printf("Email: %s\n", info);
    }
}

class MessageService implements NotificationService {
    public void sendNotification(String info) {
        System.out.printf("Message: %s\n", info);
    }
}

class WechatService implements NotificationService {
    public void sendNotification(String info) {
        System.out.printf("Wechat: %s\n", info);
    }
}
