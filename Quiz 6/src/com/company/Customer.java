package com.company;

public class Customer {
    public String name;
    public String arrivingTime;
    public String table;
    public String sittingTime;
    public String leavingTime;
    public boolean smoking;
    public Customer(String name,Boolean smoking){
        this.name = name;
        this.smoking = smoking;
    }
}
