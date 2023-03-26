package v19_facade.java;


class Billing {
    public Payment getPaymentForOrder(int orderId) {
        // Implementation
    }

    public RefundStatus processRefund(Payment payment) {
        // Implementation
    }
}

class Shipping {
    public void updateShippingAddress(int orderId, String newAddress) {
        // Implementation
    }
}

class CustomerService {
    public void notifyCustomer(String message) {
        // Implementation
    }

    public void escalateToManager(Issue issue) {
        // Implementation
    }
}

public class CustomerSupportFacade {
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

// Usage
public class Client {
    public static void main(String[] args) {
        Billing billing = new Billing();
        Shipping shipping = new Shipping();
        CustomerService customerService = new CustomerService();

        CustomerSupportFacade customerSupport = new CustomerSupportFacade(billing, shipping, customerService);
        customerSupport.handleRefundRequest(12345);
        customerSupport.changeShippingAddress(12345, "New Address");
    }
}
