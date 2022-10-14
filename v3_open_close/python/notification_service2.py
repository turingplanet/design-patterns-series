class NotificationService:

    def send_notification(self, info):
        pass

class EmailService(NotificationService):

    def send_notification(self, info):
        print(f'Email: {info}')

class MessageService(NotificationService):

    def send_notification(self, info):
        print(f'Message: {info}')
    
class WeChatService(NotificationService):

    def send_notification(self, info):
        print(f'WeChat: {info}')

class NotificationService2:

    def send_notification(self, notification_service, info):
        notification_service.send_notification(info)

ns = NotificationService2()
ns.send_notification(EmailService(), 'hello')
ns.send_notification(MessageService(), 'hello')
ns.send_notification(WeChatService(), 'hello')

