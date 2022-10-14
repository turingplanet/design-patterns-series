class EmailService:

    def send_notification(self, info):
        print(f'Email: {info}')

class MessageService:

    def send_notification(self, info):
        print(f'Message: {info}')

class NotificationService1:

    def send_notification(self, service_type, info):
        if service_type == 'email':
            self.send_email(info)
        elif service_type == 'message':
            self.send_message(info)
    
    def send_email(self, info):
        es = EmailService()
        es.send_notification(info)
    
    def send_message(self, info):
        ms = MessageService()
        ms.send_notification(info)

ns = NotificationService1()
ns.send_notification('email', 'hello')
ns.send_notification('message', 'hello')
