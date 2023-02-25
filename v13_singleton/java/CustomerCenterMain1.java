package v13_singleton.java;

import java.util.*;

class Worker {
    private String name;
    public Worker(String name) {
        this.name = name;
    }
    
    public void serviceCustomer() {
        System.out.println(this.name + " is servicing customer");
    }
}

class CustomerServiceCenter {
    private boolean holiday;
    private List<Worker> holidayWorkers;
    private List<Worker> nonHolidayWorkers;

    public CustomerServiceCenter(boolean holiday) {
        this.holiday = holiday;
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
    
    public void serviceCustomer() {
        if (this.holiday) {
            // Service by holiday workers
            for (Worker worker : this.holidayWorkers) {
                worker.serviceCustomer();
            }
        } else {
            // Service by non-holiday workers
            for (Worker worker : this.nonHolidayWorkers) {
                worker.serviceCustomer();
            }
        }
    }

}

public class CustomerCenterMain1 {
    public static void main(String[] args) {
        // Not on a holiday
        CustomerServiceCenter customerService1 = new CustomerServiceCenter(false);
        customerService1.serviceCustomer();
        // On a holiday
        CustomerServiceCenter customerService2 = new CustomerServiceCenter(false);
        customerService2.serviceCustomer();
        customerService1.setHoliday(true);
        customerService1.serviceCustomer();
        customerService2.serviceCustomer();
    }
}
