package v16_bridge.java;

public class Exampl1Main1 {
    
}

public class OnlineStore {
    public static void main(String[] args) {
        // Create different payment options
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        PayPalPayment payPalPayment = new PayPalPayment();
        GooglePayPayment googlePayPayment = new GooglePayPayment();

        // Create different products
        Book book = new Book();
        Electronics electronics = new Electronics();
        Clothing clothing = new Clothing();

        // Purchase products with different payment options
        book.purchaseWithCreditCard(new CreditCard());
        electronics.purchaseWithCreditCard(new CreditCard());
        clothing.purchaseWithCreditCard(new CreditCard());

        book.purchaseWithPayPal(new PayPalAccount());
        electronics.purchaseWithPayPal(new PayPalAccount());
        clothing.purchaseWithPayPal(new PayPalAccount());

        book.purchaseWithGooglePay(new GooglePayAccount());
        electronics.purchaseWithGooglePay(new GooglePayAccount());
        clothing.purchaseWithGooglePay(new GooglePayAccount());
    }
}

// Product classes
class Book {
    public void purchaseWithCreditCard(CreditCard creditCard) {
        // process credit card payment
        System.out.println("Processing credit card payment for book");
        // purchase book
        System.out.println("Purchased book");
    }

    public void purchaseWithPayPal(PayPalAccount payPalAccount) {
        // process PayPal payment
        System.out.println("Processing PayPal payment for book");
        // purchase book
        System.out.println("Purchased book");
    }

    public void purchaseWithGooglePay(GooglePayAccount googlePayAccount) {
        // process Google Pay payment
        System.out.println("Processing Google Pay payment for book");
        // purchase book
        System.out.println("Purchased book");
    }
}

class Electronics {
    public void purchaseWithCreditCard(CreditCard creditCard) {
        // process credit card payment
        System.out.println("Processing credit card payment for electronics");
        // purchase electronics
        System.out.println("Purchased electronics");
    }

    public void purchaseWithPayPal(PayPalAccount payPalAccount) {
        // process PayPal payment
        System.out.println("Processing PayPal payment for electronics");
        // purchase electronics
        System.out.println("Purchased electronics");
    }

    public void purchaseWithGooglePay(GooglePayAccount googlePayAccount) {
        // process Google Pay payment
        System.out.println("Processing Google Pay payment for electronics");
        // purchase electronics
        System.out.println("Purchased electronics");
    }
}

class Clothing {
    public void purchaseWithCreditCard(CreditCard creditCard) {
        // process credit card payment
        System.out.println("Processing credit card payment for clothing");
        // purchase clothing
        System.out.println("Purchased clothing");
    }

    public void purchaseWithPayPal(PayPalAccount payPalAccount) {
        // process PayPal payment
        System.out.println("Processing PayPal payment for clothing");
        // purchase clothing
        System.out.println("Purchased clothing");
    }

    public void purchaseWithGooglePay(GooglePayAccount googlePayAccount) {
        // process Google Pay payment
        System.out.println("Processing Google Pay payment for clothing");
        // purchase clothing
        System.out.println("Purchased clothing");
    }
}

// Payment classes
class CreditCardPayment {
    public void processPayment(CreditCard creditCard) {
        // process credit card payment
        System.out.println("Processing credit card payment");
    }
}

class PayPalPayment {
    public void processPayment(PayPalAccount payPalAccount) {
        // process PayPal payment
        System.out.println("Processing PayPal payment");
    }
}

class GooglePayPayment {
    public void processPayment(GooglePayAccount googlePayAccount) {
        // process Google Pay payment
        System.out.println("Processing Google Pay payment");
    }
}

