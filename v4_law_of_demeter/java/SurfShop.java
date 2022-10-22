public class SurfShop {

    public static void main(String[] args) {
        SurfShop surfShop = new SurfShop();
        Customer customer = new Customer();
        surfShop.chargeCustomer(customer, 10);
        System.out.println("Done");
    }

    public void chargeCustomer(Customer c, float fee) {
        c.getCard().balance -= fee;
    }
}

class Customer {

    private Card card = new Card();

    public Card getCard() {
        return this.card;
    }

}

class Card {

    public int balance = 10;

}
