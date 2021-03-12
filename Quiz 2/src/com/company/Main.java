package com.company;

public class Main {

    public static void main(String[] args) {

        // Custom Scenario
        OnlineClass online_class = new OnlineClass(0, 0, "Data Structures Lab", 0);


        // Current Class Information
        System.out.println("Start off Class Information:");
        online_class.toString();

        System.out.println();

        // Registering 15 Grad students
        for (int i = 0; i < 15; i++) {
            online_class.registerGrad(1);
        }

        // Unregistering 16 Grad students
        for (int i = 0; i < 16; i++) {
            online_class.unregisterGrad(1);
        }

        // Register 100 Under Grad students
        for (int i = 0; i < 100; i++) {
            online_class.registerUnderGrad(1);
        }

        // Register 50 Grad students
        for (int i = 0; i < 50; i++) {
            online_class.registerGrad(1);
        }


        System.out.println();

        // Final Class Information
        System.out.println("Final Class Information:");
        online_class.toString();
    }
}
