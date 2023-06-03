class TextEditor2:
    def __init__(self):
        self.content = []

    def write(self, text):
        self.content.append(text)
        print("Current content: " + ''.join(self.content))

    def save(self):
        return self.Memento(''.join(self.content))

    def restore(self, memento):
        self.content = list(memento.get_content())

    class Memento:
        def __init__(self, content):
            self.content = content

        def get_content(self):
            return self.content


# main function
def main():
    # Create a text editor
    editor = TextEditor2()

    # Edit text
    editor.write("This is the first sentence.")
    saved = editor.save()  # Save current state

    editor.write(" This is the second sentence.")
    print("Before restore: " + editor.save().get_content())  # Print current text

    # Restore to previous state
    editor.restore(saved)
    print("After restore: " + editor.save().get_content())  # Print current text


if __name__ == "__main__":
    main()

