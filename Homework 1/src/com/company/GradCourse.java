package com.company;

public class GradCourse extends CourseRegistration {

    public int underGradQuota = 0;

    public GradCourse(int numberOfRegisteredUnderGradStudents, int numberOfRegisteredGradStudents, String courseName, int maximumClassSize, int underGradQuota) {
        super(numberOfRegisteredUnderGradStudents, numberOfRegisteredGradStudents, courseName, maximumClassSize);
        this.underGradQuota = underGradQuota;
    }

    // Registering an undergrad student -> Checking both for the cases if undergrad quota has been reached and also if undergrad limit
    // was not reached, does it surpass the total register class size amount or not
    public String registerUnderGrad(int students) {
        if (this.numberOfRegisteredUnderGradStudents + students > this.underGradQuota) {
            System.out.println("The quote for the undergrad students has been reached for this course! Unfortunately, you can not take this class!");
            return "The quote for the undergrad students has been reached for this course! Unfortunately, you can not take this class!";
        } else if (this.numberOfRegisteredUnderGradStudents + this.numberOfRegisteredGradStudents + students > this.maximumClassSize) {
            System.out.println("The maximum class size has been reached! Unfortunately, you can not take this class!");
            return "The maximum class size has been reached! Unfortunately, you can not take this class!";
        } else {
            this.numberOfRegisteredUnderGradStudents += students;
            return (students + " student have been registered to the " + this.courseName + " course!");
        }
    }

    // Unregistering an undergrad student
    public String unregisterUnderGrad(int students) {
        if (this.numberOfRegisteredUnderGradStudents - students < 0) {
            System.out.println("The number of registered students to this course is 0! You can not unregister any more undergrad students!");
            return "The number of registered students to this course is 0! You can not unregister any more undergrad students!";
        } else {
            this.numberOfRegisteredUnderGradStudents -= students;
            System.out.println(students + " students have been unregistered from the " + this.courseName + " course!");
            return (students + " student have been unregistered from the " + this.courseName + " course!");
        }
    }

    // Registering the Grad students -> if only the maximumClassSize condition is met, student can take class instantly besides the undergrad students
    public String registerGrad(int students) {
        if (this.numberOfRegisteredGradStudents + students > this.maximumClassSize) {
            System.out.println("The maximum class size has been reached! Unfortunately, you can not take this class!");
            return "The maximum class size has been reached! Unfortunately, you can not take this class!";
        } else {
            this.numberOfRegisteredGradStudents += students;
            System.out.println(students + " student have been registered to the " + this.courseName + " course!");
            return (students + " student have been registered to the " + this.courseName + " course!");
        }
    }

    // Unregistering the grad students
    public String unregisterGrad(int students) {
        if (this.numberOfRegisteredGradStudents - students < 0) {
            System.out.println("The number of registered grad students to this course is 0! You can not unregister any more students!");
            return "The number of registered grad students to this course is 0! You can not unregister any more students!";
        } else {
            this.numberOfRegisteredGradStudents -= students;
            System.out.println(students + " students have been unregistered from the " + this.courseName + " course!");
            return (students + " students have been unregistered from the " + this.courseName + " course!");
        }
    }

    // Unique class info details
    @Override
    public String toString() {
        System.out.println("Number of registered under grad students: " + this.numberOfRegisteredUnderGradStudents + "\n" +
                "Number of registered grad students: " + this.numberOfRegisteredGradStudents + "\n" +
                "Course Name: " + this.courseName + "\n" + "Maximum class size: " + this.maximumClassSize + "\n" +
                "Undergrad Quota:" + this.underGradQuota);

        return ("Number of registered under grad students: " + this.numberOfRegisteredUnderGradStudents + "\n" +
                "Number of registered grad students: " + this.numberOfRegisteredGradStudents + "\n" +
                "Course Name: " + this.courseName + "\n" + "Maximum class size: " + this.maximumClassSize + "\n" +
                "Undergrad Quota:" + this.underGradQuota);
    }
}
