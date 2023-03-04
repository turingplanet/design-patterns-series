package v14_singleton.java;

import java.util.*;

class CustomerServiceCenter {
    private static CustomerServiceCenter __instance = null;
    private boolean holiday;
    private List<Worker> holidayWorkers;
    private List<Worker> nonHolidayWorkers;

    public static CustomerServiceCenter getInstance() {
        if (__instance == null) {
            __instance = new CustomerServiceCenter();
        }
        return __instance;
    }

    private CustomerServiceCenter() {
        if (__instance != null) {
            throw new RuntimeException("Singleton object cannot be initialized more than once");
        } else {
            __instance = this;
        }
        this.holiday = false;
        this.holidayWorkers = new ArrayList<>(Arrays.asList(
            new Worker("holiday worker 1"), 
            new Worker("holiday worker 2"), 
            new Worker("holiday worker 3")));
        this.nonHolidayWorkers = new ArrayList<>(Arrays.asList(
            new Worker("non-holiday worker 1"), 
            new Worker("non-holiday worker 2"), 
            new Worker("non-holiday worker 3")));
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public void serveCustomer() {
        if (this.holiday) {
            // Service by holiday workers
            for (Worker worker : this.holidayWorkers) {
                worker.serveCustomer();
            }
        } else {
            // Service by non-holiday workers
            for (Worker worker : this.nonHolidayWorkers) {
                worker.serveCustomer();
            }
        }
    }
}

class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void serveCustomer() {
        System.out.println(this.name + " is serving customer");
    }
}

public class CustomerCenterMain2 {
    public static void main(String[] args) {
        CustomerServiceCenter service1 = CustomerServiceCenter.getInstance();
        service1.serveCustomer();
        CustomerServiceCenter service2 = CustomerServiceCenter.getInstance();
        service2.serveCustomer();
        service2.setHoliday(true);
        service1.serveCustomer();
        service2.serveCustomer();
    }
}

