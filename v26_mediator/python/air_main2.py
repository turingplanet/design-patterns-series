from abc import ABC, abstractmethod

class Mediator(ABC):
    @abstractmethod
    def send(self, message, sender):
        pass

class Airplane:
    def __init__(self, name, mediator):
        self.name = name
        self.mediator = mediator

    def send(self, message):
        print(f'{self.name} sends message: {message}')
        self.mediator.send(message, self)

    def receive(self, message):
        print(f'{self.name} receives message: {message}')

class AirTrafficControl(Mediator):
    def __init__(self):
        self.airplanes = []

    def register_airplane(self, airplane):
        self.airplanes.append(airplane)

    def send(self, message, sender):
        for airplane in self.airplanes:
            if airplane is not sender:
                airplane.receive(message)

if __name__ == '__main__':
    atc = AirTrafficControl()

    airplane1 = Airplane('Airplane1', atc)
    airplane2 = Airplane('Airplane2', atc)
    airplane3 = Airplane('Airplane3', atc)

    atc.register_airplane(airplane1)
    atc.register_airplane(airplane2)
    atc.register_airplane(airplane3)

    airplane1.send('Hello, everyone!')
    airplane2.send('Hello, everyone!')
    airplane3.send('Hello, everyone!')


