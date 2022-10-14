public class SurfShop {

    public static void main(String[] args) {
        SurfShop surfShop = new SurfShop();
        Customer customer = new Customer();
        surfShop.chargeCustomer(customer, 10);
        System.out.println("Done");
    }

    public void chargeCustomer(Customer c, float fee) {
        c.getWallet().balance -= fee;
    }
}

class Customer {

    private Wallet wallet = new Wallet();

    public Wallet getWallet() {
        return this.wallet;
    }

}

class Wallet {

    public int balance = 10;

}
