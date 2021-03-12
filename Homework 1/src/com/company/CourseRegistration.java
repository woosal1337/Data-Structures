package com.company;

public class CourseRegistration {
    public static int numberOfRegisteredUnderGradStudents = 0;
    public static int numberOfRegisteredGradStudents = 0;
    public static String courseName;
    public static int maximumClassSize;

    // Default OOP Application

    public CourseRegistration(int numberOfRegisteredUnderGradStudents, int numberOfRegisteredGradStudents, String courseName, int maximumClassSize) {
        this.numberOfRegisteredUnderGradStudents = numberOfRegisteredUnderGradStudents;
        this.numberOfRegisteredGradStudents = numberOfRegisteredGradStudents;
        this.courseName = courseName;
        this.maximumClassSize = maximumClassSize;
    }

    // Getters
    public int number_of_registered_grad_students() {
        System.out.println(this.numberOfRegisteredGradStudents + " grad students have been registered to " + this.courseName + " course!");
        return this.numberOfRegisteredGradStudents;
    }

    public int number_of_registered_under_grad_students() {
        System.out.println(this.numberOfRegisteredGradStudents + " undergrad students have been registered to " + this.courseName + " course!");
        return this.numberOfRegisteredUnderGradStudents;
    }

    public String course_name() {
        System.out.println("Course name is: " + this.courseName);
        return this.courseName;
    }

    public int maximum_class_size() {
        System.out.println("Maximum class size for " + this.courseName + " course : " + this.maximumClassSize);
        return this.maximumClassSize;
    }

    // Setters were created in each Undergrad/Grad classes to have unique setters in each

    @Override
    public String toString() {
        System.out.println("Number of registered under grad students: " + this.numberOfRegisteredUnderGradStudents + "\n" +
                "Number of registered grad students: " + this.numberOfRegisteredGradStudents + "\n" +
                "Course Name: " + this.courseName + "\n" + "Maximum class size: " + this.maximumClassSize);

        return ("Number of registered under grad students: " + this.numberOfRegisteredUnderGradStudents + "\n" +
                "Number of registered grad students: " + this.numberOfRegisteredGradStudents + "\n" +
                "\n Course Name: " + this.courseName + "\n" + "Maximum class size: " + this.maximumClassSize);
    }

}
