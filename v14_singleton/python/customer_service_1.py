class Worker:
    def __init__(self, name):
        self.name = name
        
    def serve_customer(self):
        print(self.name + " is serving customer")

class CustomerServiceCenter:
    def __init__(self, holiday):
        self.holiday = holiday
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

customer_service1 = CustomerServiceCenter(False)
customer_service1.serve_customer()
customer_service2 = CustomerServiceCenter(False)
customer_service2.serve_customer()

customer_service1.set_holiday(True)
customer_service1.serve_customer()
customer_service2.serve_customer()


