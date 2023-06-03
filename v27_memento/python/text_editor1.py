class TextEditor1:
    def __init__(self):
        self.content = []

    def write(self, text):
        self.content.append(text)
        print("Current content: " + ''.join(self.content))

