class Book:
    def purchaseWithCreditCard(self, creditCard):
        creditCard.processPayment()
        print("Purchased book")

    def purchaseWithWeChat(self, payPalAccount):
        payPalAccount.processPayment()
        print("Purchased book")


class Electronics:
    def purchaseWithCreditCard(self, creditCard):
        creditCard.processPayment()
        print("Purchased electronics")

    def purchaseWithWeChat(self, payPalAccount):
        payPalAccount.processPayment()
        print("Purchased electronics")


class CreditCardPayment:
    def processPayment(self):
        print("Processing credit card payment")


class WeChatPayment:
    def processPayment(self):
        print("Processing wechat payment")


if __name__ == "__main__":
    book = Book()
    electronics = Electronics()

    creditCardPayment = CreditCardPayment()
    wechatPayment = WeChatPayment()

    book.purchaseWithCreditCard(creditCardPayment)
    electronics.purchaseWithCreditCard(creditCardPayment)
    book.purchaseWithWeChat(wechatPayment)
    electronics.purchaseWithWeChat(wechatPayment)

