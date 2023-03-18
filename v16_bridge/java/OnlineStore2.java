package v16_bridge.java;

interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing credit card payment");
    }
}

class WeChatPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing wechat payment");
    }
}

abstract class Product {
    protected Payment payment;
    public Product(Payment payment) {
        this.payment = payment;
    }
    public abstract void purchase();
}

class Book extends Product {
    public Book(Payment payment) {
        super(payment);
    }
    public void purchase() {
        this.payment.processPayment();
        System.out.println("Purchased book");
    }
}

class Electronics extends Product {
    public Electronics(Payment payment) {
        super(payment);
    }
    public void purchase() {
        this.payment.processPayment();
        System.out.println("Purchased electronics");
    }
}


public class OnlineStore2 {
    public static void main(String[] args) {

        Payment creditCardPayment = new CreditCardPayment();
        Payment wechatPayment = new WeChatPayment();
        Book book = new Book(creditCardPayment);
        book.purchase();
        Electronics electronics = new Electronics(creditCardPayment);
        electronics.purchase();
        Book book2 = new Book(wechatPayment);
        book2.purchase();
    }
}
