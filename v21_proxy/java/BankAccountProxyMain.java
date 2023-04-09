package v21_proxy.java;

interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
}

class RealBankAccount implements BankAccount {
    private double balance;

    public RealBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", new balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", new balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class BankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;
    private String userRole;

    public BankAccountProxy(String userRole, double initialBalance) {
        this.userRole = userRole;
        this.realBankAccount = new RealBankAccount(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (userRole.equals("Admin") || userRole.equals("User")) {
            realBankAccount.deposit(amount);
        } else {
            System.out.println("Unauthorized access");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (userRole.equals("Admin")) {
            realBankAccount.withdraw(amount);
        } else {
            System.out.println("Unauthorized access");
        }
    }
}

public class BankAccountProxyMain {
    public static void main(String[] args) {
        BankAccount adminAccount = new BankAccountProxy("Admin", 1000);
        adminAccount.deposit(500);
        adminAccount.withdraw(200);

        BankAccount userAccount = new BankAccountProxy("User", 1000);
        userAccount.deposit(500);
        userAccount.withdraw(200); // Will print "Unauthorized access"
    }
}
