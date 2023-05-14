# no pattern
class User:
    def __init__(self, name):
        self.name = name

    def send_message(self, recipient, message):
        print(f'{self.name} to {recipient.name}: {message}')

user1 = User("Alice")
user2 = User("Bob")
user3 = User("Charlie")

user1.send_message(user2, "Hello, Bob!")

# yes pattern
class User:
    def __init__(self, name):
        self.name = name

    def send_message(self, mediator, recipient_name, message):
        mediator.send(self, recipient_name, message)

class ChatRoom:
    def __init__(self):
        self.users = {}

    def add_user(self, user):
        self.users[user.name] = user

    def send(self, sender, recipient_name, message):
        recipient = self.users.get(recipient_name)
        if recipient:
            print(f'{sender.name} to {recipient_name}: {message}')
        else:
            print(f'{sender.name} to {recipient_name}: User not found')

chat_room = ChatRoom()
user1 = User("Alice")
user2 = User("Bob")
user3 = User("Charlie")
chat_room.add_user(user1)
chat_room.add_user(user2)
chat_room.add_user(user3)

user1.send_message(chat_room, "Bob", "Hello, Bob!")
