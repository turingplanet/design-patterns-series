package v19_facade.java;

class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

enum RefundStatus {
    SUCCESS, FAILURE
}

class Billing {
    public Payment getPaymentForOrder(int orderId) {
        // Simple Implementation
        return new Payment(50.0);
    }

    public RefundStatus processRefund(Payment payment) {
        // Simple Implementation
        if (payment.getAmount() > 0) {
            return RefundStatus.SUCCESS;
        } else {
            return RefundStatus.FAILURE;
        }
    }
}

class Shipping {
    public void updateShippingAddress(int orderId, String newAddress) {
        System.out.println("Shipping address for order " + orderId + " updated to: " + newAddress);
    }
}

class Issue {
    private String description;

    public Issue(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class CustomerService {
    public void notifyCustomer(String message) {
        System.out.println("Notification sent to customer: " + message);
    }

    public void escalateToManager(Issue issue) {
        System.out.println("Issue escalated to manager: " + issue.getDescription());
    }
}

class CustomerSupportFacade {
    private Billing billing;
    private Shipping shipping;
    private CustomerService customerService;

    public CustomerSupportFacade(Billing billing, Shipping shipping, CustomerService customerService) {
        this.billing = billing;
        this.shipping = shipping;
        this.customerService = customerService;
    }

    public void handleRefundRequest(int orderId) {
        Payment payment = billing.getPaymentForOrder(orderId);
        RefundStatus refundStatus = billing.processRefund(payment);
        customerService.notifyCustomer("Refund status: " + refundStatus);
    }

    public void changeShippingAddress(int orderId, String newAddress) {
        shipping.updateShippingAddress(orderId, newAddress);
        customerService.notifyCustomer("Shipping address updated");
    }

    public void escalateToManager(Issue issue) {
        customerService.escalateToManager(issue);
    }
}
public class CustomerSuportClient {
    public static void main(String[] args) {
        Billing billing = new Billing();
        Shipping shipping = new Shipping();
        CustomerService customerService = new CustomerService();

        CustomerSupportFacade customerSupport = new CustomerSupportFacade(billing, shipping, customerService);
        customerSupport.handleRefundRequest(12345);
        customerSupport.changeShippingAddress(12345, "123 New Street, New York, NY 10001");
        Issue issue = new Issue("Product not working properly");
        customerSupport.escalateToManager(issue);
    }
}
