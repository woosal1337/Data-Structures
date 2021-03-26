package com.company;

import java.util.ArrayList;

public class DoublyCourseGrades {
    protected String course_name;
    protected int number_of_students;
    protected DoublyLinkedList student_names;
    protected DoublyLinkedList grades;

    public DoublyCourseGrades(String course_name, DoublyLinkedList student_names, DoublyLinkedList grades) {
        this.course_name = course_name;
        this.student_names = student_names;
        this.number_of_students = this.student_names.size();
        this.grades = grades;
    }

    // Getters
    public String get_course_name() {
        return this.course_name;
    }

    public int get_number_of_students() {
        return this.student_names.size();
    }

    public DoublyLinkedList get_student_names() {
        return this.student_names;
    }

    public DoublyLinkedList get_grades() {
        return this.grades;
    }

    // Setters
    public void set_course_name(String course_name) {
        this.course_name = course_name;
    }

    public void set_student_names(DoublyLinkedList student_names) {
        this.student_names = student_names;
    }

    public void set_grades(DoublyLinkedList grades) {
        this.grades = grades;
    }

    public void add_student(String student_name, int student_grade) {
        this.student_names.add(student_name);
        grades.add(student_grade);
    }

    public void change_grade(String studentName, int grade) {
        int i = student_names.index_of(studentName);
        grades.set(i, grade);
    }


    public DoublyLinkedList print_names(String l_grade) {
        DoublyLinkedList students = new DoublyLinkedList();

        if (l_grade == "F") {
            for (int i = 0; i < get_student_names().size(); i++) {
                if ((Integer) grades.get(i) < 60) {
                    students.add(get_student_names().get(i));
                }
            }
            System.out.print("Grade of the students: " + l_grade + ": ");
            students.print_list();
            System.out.println();
        } else if (l_grade == "C") {
            for (int i = 0; i < get_student_names().size(); i++) {
                if ((Integer) grades.get(i) < 75 && (Integer) grades.get(i) >= 60) {
                    students.add(get_student_names().get(i));
                }
            }
            System.out.print("Grade of the students: " + l_grade + ": ");
            students.print_list();
            System.out.println();
        } else if (l_grade == "B") {
            for (int i = 0; i < get_student_names().size(); i++) {
                if ((Integer) grades.get(i) < 90 && (Integer) grades.get(i) >= 75) {
                    students.add(get_student_names().get(i));
                }
            }
            System.out.print("Grade of the students: " + l_grade + ": ");
            students.print_list();
            System.out.println();
        } else if (l_grade == "A") {
            for (int i = 0; i < get_student_names().size(); i++) {
                if ((Integer) grades.get(i) <= 100 && (Integer) grades.get(i) >= 90) {
                    students.add(get_student_names().get(i));
                }
            }
            System.out.print("Students with letter grade " + l_grade + ": ");
            students.print_list();
            System.out.println();
        }
        return students;
    }

    public int find_max() {

        // Finding the greatest grade among the student
        int max = 0;
        for (int i = 0; i < get_student_names().size(); i++) {
            if ((Integer) grades.get(i) > max) {
                max = (Integer) grades.get(i);
            }
        }

        // Finding all the students who has the highest grade
        System.out.println("Student(s) with the highest grade(s): \n");

        for (int i = 0; i < get_student_names().size(); i++) {
            if ((Integer) grades.get(i) == max) {
                System.out.println(get_student_names().get(i));
            }
        }

        return max;
    }

    public String toString() {
        System.out.println("Course Name: " + get_course_name());
        System.out.println("Number of students: " + get_number_of_students());

        for (int i = 0; i < get_student_names().size(); i++) {
            System.out.print(get_student_names().get(i) + ": " + get_grades().get(i));
            System.out.println();
        }
        System.out.println();

        return ("Course Name: " + get_course_name() +
                "Number of students: " + get_number_of_students());
    }

}
