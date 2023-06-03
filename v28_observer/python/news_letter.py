from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, message):
        pass

class Reader(Observer):
    def __init__(self, name):
        self.name = name

    def update(self, message):
        print(f"Notification to {self.name}: {message}")

class Subject(ABC):
    @abstractmethod
    def register_observer(self, observer):
        pass

    @abstractmethod
    def remove_observer(self, observer):
        pass

    @abstractmethod
    def notify_observers(self):
        pass

class NewsletterPublisher(Subject):
    def __init__(self):
        self.readers = []
        self.latest_newsletter = None

    def register_observer(self, observer):
        self.readers.append(observer)

    def remove_observer(self, observer):
        self.readers.remove(observer)

    def publish(self, newsletter):
        self.latest_newsletter = newsletter
        self.notify_observers()

    def notify_observers(self):
        for observer in self.readers:
            observer.update(self.latest_newsletter)


if __name__ == "__main__":
    publisher = NewsletterPublisher()

    alice = Reader("Alice")
    bob = Reader("Bob")
    charlie = Reader("Charlie")

    publisher.register_observer(alice)
    publisher.register_observer(bob)

    publisher.publish("New edition of the newsletter is out!")

    publisher.register_observer(charlie)
    publisher.remove_observer(alice)

    publisher.publish("Another edition of the newsletter is here!")


