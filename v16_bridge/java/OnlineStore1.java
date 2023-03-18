package v16_bridge.java;

class Book {
    public void purchaseWithCreditCard(CreditCardPayment creditCard) {
        creditCard.processPayment();
        System.out.println("Purchased book");
    }

    public void purchaseWithWeChat(WeChatPayment payPalAccount) {
        payPalAccount.processPayment();
        System.out.println("Purchased book");
    }
}

class Electronics {
    public void purchaseWithCreditCard(CreditCardPayment creditCard) {
        creditCard.processPayment();
        System.out.println("Purchased electronics");
    }

    public void purchaseWithWeChat(WeChatPayment payPalAccount) {
        payPalAccount.processPayment();
        System.out.println("Purchased electronics");
    }

}

class CreditCardPayment {
    public void processPayment() {
        System.out.println("Processing credit card payment");
    }
}

class WeChatPayment {
    public void processPayment() {
        System.out.println("Processing wechat payment");
    }
}

public class OnlineStore1 {
    public static void main(String[] args) {
        Book book = new Book();
        Electronics electronics = new Electronics();

        CreditCardPayment creditCardPayment = new CreditCardPayment();
        WeChatPayment wechatPayment = new WeChatPayment();

        book.purchaseWithCreditCard(creditCardPayment);
        electronics.purchaseWithCreditCard(creditCardPayment);
        book.purchaseWithWeChat(wechatPayment);
        electronics.purchaseWithWeChat(wechatPayment);
    }
}