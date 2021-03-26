package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

        // 1st part using Arrays
        CourseGrades lecture = new CourseGrades("Data Structures", new ArrayList<String>(), new ArrayList<Integer>());
        for (int i = 1; i < 16; i++) {

            lecture.add_student("Student ID" + i, rand.nextInt(101));
        }

        lecture.print_names("A");
        lecture.print_names("B");
        lecture.print_names("C");

        ArrayList<String> failedStudents = lecture.print_names("F");
        for (String student : failedStudents) {

            lecture.change_grade(student, rand.nextInt(101));
        }

        System.out.println();

        System.out.println("Resit exam for the people who failed");
        System.out.println();
        lecture.print_names("A");
        lecture.print_names("B");
        lecture.print_names("C");
        lecture.print_names("F");

        System.out.println();

        lecture.toString();

        System.out.println("\n\n");

        // 2nd part using Linked list
        DoublyCourseGrades dcg = new DoublyCourseGrades("Calculus", new DoublyLinkedList(), new DoublyLinkedList());
        for (int i = 1; i <= 15; i++) {
            dcg.add_student("Student ID" + i, rand.nextInt(101));
        }
        dcg.print_names("A");
        dcg.print_names("B");
        dcg.print_names("C");
        DoublyLinkedList failed_students = dcg.print_names("F");
        for (int i = 0; i < failed_students.size(); i++) {
            dcg.change_grade(failed_students.get(i).toString(), rand.nextInt(101));
        }
        System.out.println("Resit exam for the people who failed \n");
        dcg.print_names("A");
        dcg.print_names("B");
        dcg.print_names("C");
        dcg.print_names("F");

        dcg.toString();
    }
}