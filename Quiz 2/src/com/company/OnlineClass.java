package com.company;

public class OnlineClass extends CourseRegistration {


    public OnlineClass(int numberOfRegisteredUnderGradStudents, int numberOfRegisteredGradStudents, String courseName, int maximumClassSize) {
        super(numberOfRegisteredUnderGradStudents, numberOfRegisteredGradStudents, courseName, maximumClassSize);
    }

    // Registering Under Grad Student -> No if-else conditions are applied as maximum class size does not exist!
    public String registerUnderGrad(int student) {
        this.numberOfRegisteredUnderGradStudents += student;

        System.out.println("New Under Grad Student has been registered to " + this.courseName + " course!");
        return ("New Under Grad Student has been registered to " + this.courseName + " course!");
    }

    // Registering Grad Student -> No if-else conditions are applied as maximum class size does not exist!
    public String registerGrad(int student) {
        this.numberOfRegisteredGradStudents += student;
        System.out.println("New Grad Student has been registered to " + this.courseName + " course!");
        return ("New Grad Student has been registered to " + this.courseName + " course!");
    }

    // Unregister Under Grad Student
    public String unregisterUnderGrad(int student) {
        if (this.numberOfRegisteredUnderGradStudents == 0) {
            System.out.println("There are no any grad student who has registered to this course yet!");
            return "There are no any grad student who has registered to this course yet!";
        } else {
            this.numberOfRegisteredUnderGradStudents -= student;
            System.out.println("1 student has been unregistered from" + this.courseName + " class!");
            return ("1 student has been unregistered from" + this.courseName + " class!");
        }

    }

    // Unregister Grad Student
    public String unregisterGrad(int student) {
        if (this.numberOfRegisteredGradStudents == 0) {
            System.out.println("There are no any grad student who has registered to this course yet!");
            return "There are no any grad student who has registered to this course yet!";
        } else {
            this.numberOfRegisteredGradStudents -= student;
            System.out.println("1 student has been unregistered from" + this.courseName + " class!");
            return ("1 student has been unregistered from" + this.courseName + " class!");
        }

    }

    // Unique class info details
    @Override
    public String toString() {
        System.out.println("Number of registered under grad students: " + this.numberOfRegisteredUnderGradStudents + "\n" +
                "Number of registered grad students: " + this.numberOfRegisteredGradStudents + "\n" +
                "Course Name: " + this.courseName);

        return ("Number of registered under grad students: " + this.numberOfRegisteredUnderGradStudents + "\n" +
                "Number of registered grad students: " + this.numberOfRegisteredGradStudents + "\n" +
                "Course Name: " + this.courseName);
    }
}
