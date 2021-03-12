package com.company;

public class Main {

    public static void main(String[] args) {
        // 1st Scenario
        // Undergrad course
        // Max size: 20

        // Scenario 1 //
        UndergradCourse under_grad_program = new UndergradCourse(0, 0, "UnderGrad Data Structures Course", 20);

        System.out.println("Scenario 1:\n");

        // Current class info
        System.out.println("Starting Class info:");
        under_grad_program.toString();

        System.out.println();

        // Register 10 Under Grad Students
         for (int i = 0; i < 10; i++) {
            under_grad_program.registerUnderGrad(1);
         }

        // Register 3 Grad Students
        for (int i = 0; i < 3; i++) {
            under_grad_program.registerGrad(3);
        }

        // Register 15 Under Grad Students
        for (int i = 0; i < 15; i++) {
            under_grad_program.registerUnderGrad(1);
        }

        // Unregister 7 Under Grad Students
        for (int i = 0; i < 7; i++) {
            under_grad_program.unregisterUnderGrad(1);
        }

        // Final class info
        System.out.println("\nFinal Class info:");
        under_grad_program.toString();
        ///////////////////////////////////////////


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////" +
                "////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Scenario 2 //
        GradCourse grad_program = new GradCourse(0, 0, "Grad Data Structures Course", 10, 4);

        // Current class info
        System.out.println("Starting Grad Class info:");
        grad_program.toString();

        System.out.println();

        // Register 5 Undergrad
        for (int i = 0; i < 5; i++) {
            grad_program.registerUnderGrad(1);
        }

        // Register 6 Grads
        for (int i = 0; i < 6; i++) {
            grad_program.registerGrad(1);
        }

        // Unregister 1 Undergrad
        grad_program.unregisterUnderGrad(1);

        // Register 4 Grads
        for (int i = 0; i < 4; i++) {
            grad_program.registerGrad(1);
        }

        // Final class info
        System.out.println("\nFinal Grad Class info:");
        grad_program.toString();

    }
}
