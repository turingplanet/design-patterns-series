# no pattern
class TextEditor:
    def __init__(self, text=""):
        self.text = text
        self.history = []

    def write(self, new_text):
        self.history.append(self.text)
        self.text += new_text

    def undo(self):
        if len(self.history) > 0:
            self.text = self.history.pop()
# with pattern
class Memento:
    def __init__(self, state):
        self._state = state

    def get_state(self):
        return self._state

class TextEditor:
    def __init__(self, text=""):
        self.text = text

    def write(self, new_text):
        return Memento(self.text)

    def restore(self, memento):
        self.text = memento.get_state()

class History:
    def __init__(self):
        self._history = []

    def push(self, memento):
        self._history.append(memento)

    def pop(self):
        return self._history.pop() if self._history else None

