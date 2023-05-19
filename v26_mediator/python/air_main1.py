class Airplane:
    def __init__(self, name):
        self.name = name

    def send(self, message, receiver):
        print(f'{self.name} sends message to {receiver.name}: {message}')
        receiver.receive(message, self)

    def receive(self, message, sender):
        print(f'{self.name} receives message from {sender.name}: {message}')


if __name__ == '__main__':
    airplane1 = Airplane('Airplane1')
    airplane2 = Airplane('Airplane2')
    airplane3 = Airplane('Airplane3')

    airplane1.send('Hello, Airplane2!', airplane2)
    airplane2.send('Hello, Airplane3!', airplane3)
    airplane3.send('Hello, Airplane1!', airplane1)

