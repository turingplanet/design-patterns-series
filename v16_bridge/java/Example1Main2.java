package v16_bridge.java;

public class Example1Main2 {
    
}

// Product hierarchy
interface Product {
    void purchase(Payment payment);
}

class Book implements Product {
    public void purchase(Payment payment) {
        payment.processPayment();
        System.out.println("Purchased Book");
    }
}

class Electronics implements Product {
    public void purchase(Payment payment) {
        payment.processPayment();
        System.out.println("Purchased Electronics");
    }
}

class Clothing implements Product {
    public void purchase(Payment payment) {
        payment.processPayment();
        System.out.println("Purchased Clothing");
    }
}

// Payment hierarchy
interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing credit card payment");
    }
}

class PayPalPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing PayPal payment");
    }
}

class GooglePayPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing Google Pay payment");
    }
}

// Bridge to connect Product and Payment hierarchies
class ProductPaymentBridge {
    private Payment payment;
    public ProductPaymentBridge(Payment payment) {
        this.payment = payment;
    }
    public void purchaseProduct(Product product) {
        product.purchase(payment);
    }
}

// Client code
public class OnlineStore {
    public static void main(String[] args) {
        // Create different payment options
        Payment creditCardPayment = new CreditCardPayment();
        Payment payPalPayment = new PayPalPayment();
        Payment googlePayPayment = new GooglePayPayment();

        // Create different products
        Product book = new Book();
        Product electronics = new Electronics();
        Product clothing = new Clothing();

        // Connect products and payment options using the bridge
        ProductPaymentBridge bridge = new ProductPaymentBridge(creditCardPayment);
        bridge.purchaseProduct(book); // Purchase book with credit card
        bridge.purchaseProduct(electronics); // Purchase electronics with credit card
        bridge.purchaseProduct(clothing); // Purchase clothing with credit card

        bridge = new ProductPaymentBridge(payPalPayment);
        bridge.purchaseProduct(book); // Purchase book with PayPal
        bridge.purchaseProduct(electronics); // Purchase electronics with PayPal
        bridge.purchaseProduct(clothing); // Purchase clothing with PayPal

        bridge = new ProductPaymentBridge(googlePayPayment);
        bridge.purchaseProduct(book); // Purchase book with Google Pay
        bridge.purchaseProduct(electronics); // Purchase electronics with Google Pay
        bridge.purchaseProduct(clothing); // Purchase clothing with Google Pay
    }
}
