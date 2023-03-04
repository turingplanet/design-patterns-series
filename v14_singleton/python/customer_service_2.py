class Worker:
    def __init__(self, name):
        self.name = name
        
    def serve_customer(self):
        print(self.name + " is serving customer")

class CustomerServiceCenter:
    __instance = None
    
    @staticmethod
    def get_instance():
        if CustomerServiceCenter.__instance is None:
            CustomerServiceCenter()
        return CustomerServiceCenter.__instance
    
    def __init__(self):
        if CustomerServiceCenter.__instance is not None:
            raise Exception("Singleton object cannot be initialized more than once")
        else:
            CustomerServiceCenter.__instance = self
        self.holiday = False
        self.holiday_workers = [
            Worker("holiday worker 1"), 
            Worker("holiday worker 2"), 
            Worker("holiday worker 3")
        ]
        self.non_holiday_workers = [
            Worker("non-holiday worker 1"), 
            Worker("non-holiday worker 2"), 
            Worker("non-holiday worker 3")
        ]
        
    def set_holiday(self, holiday):
        self.holiday = holiday
        
    def serve_customer(self):
        if self.holiday:
            # Service by holiday workers
            for worker in self.holiday_workers:
                worker.serve_customer()
        else:
            # Service by non-holiday workers
            for worker in self.non_holiday_workers:
                worker.serve_customer()

# Use the singleton object to serve customers
service1 = CustomerServiceCenter.get_instance()
service1.serve_customer()
service2 = CustomerServiceCenter.get_instance()
service2.serve_customer()

service2.set_holiday(True)
service1.serve_customer()
service2.serve_customer()


