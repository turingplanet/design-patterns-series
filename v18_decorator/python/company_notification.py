from abc import ABC, abstractmethod

# Notifier interface
class Notifier(ABC):
    @abstractmethod
    def send(self, message: str):
        pass

# Concrete Component
class EmailNotifier(Notifier):
    def send(self, message: str):
        print(f"Sending Email message: {message}")

# Decorator abstract class
class NotifierDecorator(Notifier):
    def __init__(self, notifier: Notifier):
        self.notifier = notifier

    def send(self, message: str):
        self.notifier.send(message)

# Concrete Decorator classes
class WeChatDecorator(NotifierDecorator):
    def __init__(self, notifier: Notifier):
        super().__init__(notifier)

    def send(self, message: str):
        super().send(message)
        print(f"Sending WeChat message: {message}")

class MobileDecorator(NotifierDecorator):
    def __init__(self, notifier: Notifier):
        super().__init__(notifier)

    def send(self, message: str):
        super().send(message)
        print(f"Sending Mobile message: {message}")

# Client
if __name__ == "__main__":
    message = "Hello, this is a notification!"

    # Sending notifications using different combinations
    notifier = EmailNotifier()
    notifier = WeChatDecorator(notifier)
    notifier = MobileDecorator(notifier)
    notifier.send(message)


