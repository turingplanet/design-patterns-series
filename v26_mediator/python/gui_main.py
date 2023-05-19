from abc import ABC, abstractmethod

class Mediator(ABC):
    @abstractmethod
    def notify(self, sender, event):
        pass

class ConcreteMediator(Mediator):
    def __init__(self, button, text_box, label):
        self.button = button
        self.button.set_mediator(self)
        self.text_box = text_box
        self.text_box.set_mediator(self)
        self.label = label
        self.label.set_mediator(self)

    def notify(self, sender, event):
        if sender == self.button and event == 'clicked':
            self.text_box.clear()
            self.label.show('Button was clicked')

class Component(ABC):
    def __init__(self):
        self.mediator = None

    def set_mediator(self, mediator):
        self.mediator = mediator

    def changed(self, event):
        self.mediator.notify(self, event)

class Button(Component):
    def click(self):
        print('Button clicked')
        self.changed('clicked')

class TextBox(Component):
    def clear(self):
        print('TextBox cleared')

class Label(Component):
    def show(self, message):
        print(f'Label shows: {message}')

if __name__ == '__main__':
    button = Button()
    text_box = TextBox()
    label = Label()
    ConcreteMediator(button, text_box, label)

    # Simulate a button click
    button.click()


