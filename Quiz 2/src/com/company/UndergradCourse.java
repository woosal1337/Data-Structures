package com.company;

public class UndergradCourse extends CourseRegistration {

    public UndergradCourse(int numberOfRegisteredUnderGradStudents, int numberOfRegisteredGradStudents, String courseName, int maximumClassSize) {
        super(numberOfRegisteredUnderGradStudents, numberOfRegisteredGradStudents, courseName, maximumClassSize);
    }

    // Undergrad setter will increase the student number, however, Grad student registration will throw a warning
    public String registerUnderGrad(int student) {
        if (student + this.numberOfRegisteredUnderGradStudents > this.maximumClassSize) {
            System.out.println("The maximum class size has been reached! Unfortunately, you can not take this class!");
            return "The maximum class size has been reached! Unfortunately, you can not take this class!";
        } else {
            this.numberOfRegisteredUnderGradStudents += student;
            System.out.println(student + " student have been registered to the " + this.courseName + " course!");
            return (student + " student have been registered to the " + this.courseName + " course!");
        }
    }

    // Unregistering the under grad students from the course
    public String unregisterUnderGrad(int student) {
        if (this.numberOfRegisteredUnderGradStudents - student < 0) {
            System.out.println("The number of registered students to this course is 0! You can not unregister any more students!");
            return "The number of registered students to this course is 0! You can not unregister any more students!";
        } else {
            this.numberOfRegisteredUnderGradStudents -= student;
            System.out.println(student + " student have been unregistered from the " + this.courseName + " course!");
            return (student + " student have been unregistered from the " + this.courseName + " course!");
        }
    }

    // Registering the Grad students exception
    public String registerGrad(int student) {
        System.out.println("This is undergrad only course, grad students can not take this course!");
        return "This is undergrad only course, grad students can not take this course!";
    }

    // Unregistering the Grad students exception
    public String unregisterGrad(int student) {
        System.out.println("This is undergrad only course, grad students can not take this course!");
        return "This is undergrad only course, grad students can not take this course!";
    }
}
