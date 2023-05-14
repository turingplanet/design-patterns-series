# no pattern
class TrafficLight:
    def __init__(self):
        self.state = 'red'

    def change_state(self):
        if self.state == 'red':
            self.state = 'green'
        elif self.state == 'green':
            self.state = 'yellow'
        elif self.state == 'yellow':
            self.state = 'red'

    def get_action(self):
        if self.state == 'red':
            return "Stop"
        elif self.state == 'green':
            return "Go"
        elif self.state == 'yellow':
            return "Wait"

# yes pattern
from abc import ABC, abstractmethod

class State(ABC):
    @abstractmethod
    def change_state(self):
        pass

    @abstractmethod
    def get_action(self):
        pass

class RedState(State):
    def change_state(self):
        return GreenState()

    def get_action(self):
        return "Stop"

class GreenState(State):
    def change_state(self):
        return YellowState()

    def get_action(self):
        return "Go"

class YellowState(State):
    def change_state(self):
        return RedState()

    def get_action(self):
        return "Wait"

class TrafficLight:
    def __init__(self):
        self.state = RedState()

    def change_state(self):
        self.state = self.state.change_state()

    def get_action(self):
        return self.state.get_action()

