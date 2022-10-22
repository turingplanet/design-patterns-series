public class SurfShop2 {

    public static void main(String[] args) {
        SurfShop2 surfShop2 = new SurfShop2();
        Customer customer = new Customer();
        surfShop2.chargeCustomer(customer, 10);
        System.out.println("Done");
    }

    public void chargeCustomer(Customer c, float fee) {
        c.pay(fee);
    }
}

class Customer {

    private Card card = new Card();

    public void pay(float fee) {
        this.card.deduct(fee);
    }

}

class Card {

    public int balance = 10;

    public void deduct(float fee) {
        this.balance -= fee;
    }

}
