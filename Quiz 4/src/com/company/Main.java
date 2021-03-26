package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

        // Linked list students
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


        System.out.println(dcg.find_max());
    }
}