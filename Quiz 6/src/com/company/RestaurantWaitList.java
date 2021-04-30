package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class RestaurantWaitList {
    private final Deque<Customer> customersDeque = new ArrayDeque<>();
    private final Deque<Customer> sittingCustomers = new ArrayDeque<>();
    private final CustomerLog customerLog = new CustomerLog();
    private final DoublyLinkedList<String> tables = new DoublyLinkedList<String>(new String[]{"Table 4", "Table 5"});
    private final DoublyLinkedList<String> smokingTables = new DoublyLinkedList<String>(new String[]{"Table 1", "Table 2", "Table 3"});
    private int totalCustomerCount = 0;
    private final Time clock = new Time(3, 0);
    private int isHappyCount = 0;

    public RestaurantWaitList() {
    }

    public RestaurantWaitList(Customer[] customerList) {
        addToDeque(customerList);
    }

    public void addToDeque(Customer[] customerList) {
        for (Customer customer : customerList) {
            customer.arrivingTime = clock.WhatTimeIsIt();
            customersDeque.push(customer);
            totalCustomerCount++;
        }
    }

    public void addToDeque(Customer customer) {
        customer.arrivingTime = clock.WhatTimeIsIt();
        customersDeque.push(customer);
        totalCustomerCount++;
    }

    public void changeOrder() {
        if (customersDeque.size() > 1) {
            isHappyCount = 0;
            Customer unHappy = customersDeque.pop();
            Customer comingCustomer = customersDeque.pop();
            customersDeque.addFirst(unHappy);
            customersDeque.addFirst(comingCustomer);
            System.out.println(unHappy.name + " is unhappy, " + comingCustomer.name + " is in front of the order!");
        } else {
            isHappyCount = 2;
        }
    }

    public void customerLeaving() {
        String sittingTime;
        Integer[] timeDifference;
        Customer customer;
        for (int i = 0; i < sittingCustomers.size(); i++) {
            customer = sittingCustomers.getFirst();
            sittingTime = customer.sittingTime;
            timeDifference = clock.calculateTimeDifference(sittingTime);
            int sittingTimeLimit = (int) (Math.random() * (40 - 30 + 1) + 30);
            if (clock.processTime(clock.WhatTimeIsIt())[0] >= 10) {
                customer.leavingTime = clock.WhatTimeIsIt();
                tables.add(customer.table);
                customerLog.addLog(customer);
                sittingCustomers.remove(customer);
            } else {
                if (timeDifference[0] >= 1 || timeDifference[1] >= sittingTimeLimit) {
                    customer.leavingTime = clock.WhatTimeIsIt();
                    tables.add(customer.table);
                    customerLog.addLog(customer);
                    sittingCustomers.remove(customer);
                }  else{
                    smokingTables.add(customer.table); // add back the table to tables
                }
            }
        }
        seatCustomers();
    }

    public void seatCustomers() {
        Customer tempCustomer;
        while (tables.size() > 0 && customersDeque.size() > 0) {

            tempCustomer = customersDeque.pop();
            if (clock.calculateTimeDifference(tempCustomer.arrivingTime)[0] > 1 || clock.calculateTimeDifference(tempCustomer.arrivingTime)[1] > 30) {
                tempCustomer.leavingTime = clock.WhatTimeIsIt();
                customerLog.addLog(tempCustomer);
                System.out.println(tempCustomer.name + " is leaving as has waited more than 30 minutes!");
            } else {
                tempCustomer.table = tables.get(0);
                tables.removeIndex(0);
                tempCustomer.sittingTime = clock.WhatTimeIsIt();
                isHappyCount++;
                totalCustomerCount++;
                System.out.println(tempCustomer.name + " sat to " + tempCustomer.table + " at " + tempCustomer.sittingTime);
                sittingCustomers.push(tempCustomer);
            }
            if (isHappyCount >= 2) {
                changeOrder();
            }


        }
    }

    public boolean passTime(int minute) {
        clock.timePassed(minute);
        if (clock.processTime(clock.WhatTimeIsIt())[0] >= 10) {
            customerLeaving();
            System.out.println("Sorry, the restaurant is closed!");
            System.out.println("It is " + clock.WhatTimeIsIt() + " o'clock");
            return false;
        }
        customerLeaving();
        return true;
    }

    public void printLogs() {
        System.out.println();
        if (customerLog != null) {
            customerLog.printLogs();
        } else {
            System.out.println("There is not any log!");
        }
    }
}


class Time {
    private int currentHour;
    private int currentMinute;
    private String time;

    public Time(int currentHour, int currentMinute) {
        this.currentHour = currentHour;
        this.currentMinute = currentMinute;
    }

    private void ArrangeTime() {
        String tempHour;
        String tempMinute;
        tempHour = "" + this.currentHour;
        tempMinute = "" + this.currentMinute;
        if (this.currentHour < 10) {
            tempHour = "0" + this.currentHour;
        }
        if (this.currentMinute < 10) {
            tempMinute = "0" + this.currentMinute;
        }
        this.time = tempHour + ":" + tempMinute;
    }

    public String WhatTimeIsIt() {
        ArrangeTime();
        return this.time;
    }

    public Integer[] processTime(String time) {
        int hour = Integer.parseInt(time.substring(0, time.indexOf(":")));
        int minute = Integer.parseInt(time.substring(time.indexOf(":") + 1));
        return new Integer[]{hour, minute};
    }

    public void timePassed(int passedMinute) {
        this.currentMinute += passedMinute;
        while (this.currentMinute >= 60) {
            this.currentMinute -= 60;
            this.currentHour += 1;
        }
    }

    public Integer[] calculateTimeDifference(String time) {
        Integer[] tempGivenTime = processTime(time);
        int hourDiff = this.currentHour - tempGivenTime[0];
        int minDiff = this.currentMinute - tempGivenTime[1];
        return new Integer[]{hourDiff, minDiff};
    }
}

class CustomerLog {
    private DoublyLinkedList<Customer> log;

    public CustomerLog() {
        this.log = new DoublyLinkedList<Customer>();
    }

    private int logSize = 0;

    public void addLog(Customer log) {
        this.log.add(log);
        logSize++;
    }

    public void printLogs() {
        String name;
        String sittingTime;
        String leavingTime;
        String arriveTime;
        String table;
        Customer tempCustomer;
        System.out.println("Name\t\tArriving Time\t\tSitting Time\t\tLeaving Time\t\tTable Number\t\tCustomer Smoking");
        for (int i = 0; i < this.logSize; i++) {
            tempCustomer = log.get(i);
            if (tempCustomer.sittingTime == null) {
                System.out.println(tempCustomer.name + " \t\t" + tempCustomer.arrivingTime + "\t\t\t\t" + " " + "\t\t\t\t\t" + tempCustomer.leavingTime + "\t\t\t\t" + " " + "\t\t\t\t\t" + tempCustomer.smoking + " ");
            } else {
                System.out.println(tempCustomer.name + " \t\t" + tempCustomer.arrivingTime + "\t\t\t\t" + tempCustomer.sittingTime + "\t\t\t\t" + tempCustomer.leavingTime + "\t\t\t\t" + tempCustomer.table  + "\t\t\t\t\t" + tempCustomer.smoking + " ");
            }
        }
    }
}