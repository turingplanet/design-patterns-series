from enum import Enum

class Payment:
    def __init__(self, amount):
        self.amount = amount

    def get_amount(self):
        return self.amount

class RefundStatus(Enum):
    SUCCESS = 1
    FAILURE = 2

class Billing:
    def get_payment_for_order(self, order_id):
        # Simple Implementation
        return Payment(50.0)

    def process_refund(self, payment):
        # Simple Implementation
        if payment.get_amount() > 0:
            return RefundStatus.SUCCESS
        else:
            return RefundStatus.FAILURE

class Shipping:
    def update_shipping_address(self, order_id, new_address):
        print(f"Shipping address for order {order_id} updated to: {new_address}")

class Issue:
    def __init__(self, description):
        self.description = description

    def get_description(self):
        return self.description

class CustomerService:
    def notify_customer(self, message):
        print(f"Notification sent to customer: {message}")

    def escalate_to_manager(self, issue):
        print(f"Issue escalated to manager: {issue.get_description()}")

class CustomerSupportFacade:
    def __init__(self, billing, shipping, customer_service):
        self.billing = billing
        self.shipping = shipping
        self.customer_service = customer_service

    def handle_refund_request(self, order_id):
        payment = self.billing.get_payment_for_order(order_id)
        refund_status = self.billing.process_refund(payment)
        self.customer_service.notify_customer(f"Refund status: {refund_status}")

    def change_shipping_address(self, order_id, new_address):
        self.shipping.update_shipping_address(order_id, new_address)
        self.customer_service.notify_customer("Shipping address updated")

    def escalate_to_manager(self, issue):
        self.customer_service.escalate_to_manager(issue)

class CustomerSupportClient:
    @staticmethod
    def main():
        billing = Billing()
        shipping = Shipping()
        customer_service = CustomerService()

        customer_support = CustomerSupportFacade(billing, shipping, customer_service)
        customer_support.handle_refund_request(12345)
        customer_support.change_shipping_address(12345, "123 New Street, New York, NY 10001")
        issue = Issue("Product not working properly")
        customer_support.escalate_to_manager(issue)

if __name__ == "__main__":
    CustomerSupportClient.main()
