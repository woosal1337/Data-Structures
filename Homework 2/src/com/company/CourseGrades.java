package com.company;

import java.util.ArrayList;

public class CourseGrades {
    protected String course_name;
    protected int number_of_students;
    protected ArrayList<String> student_names;
    protected ArrayList<Integer> grades;

    public CourseGrades(String course_name, ArrayList<String> student_names, ArrayList<Integer> grades) {
        this.course_name = course_name;
        this.student_names = student_names;
        this.number_of_students = this.student_names.size();
        this.grades = grades;
    }


    public String get_course_name() {
        return this.course_name;
    }

    public int get_number_of_students() {
        return this.student_names.size();
    }

    public ArrayList<String> get_student_names() {
        return student_names;
    }

    public ArrayList<Integer> get_grades() {
        return grades;
    }

    public void set_course_name(String new_course_name) {
        this.course_name = new_course_name;
    }

    public void set_student_names(ArrayList<String> new_student_names) {
        this.student_names = new_student_names;
    }

    public void set_grades(ArrayList<Integer> new_grades) {
        this.grades = new_grades;
    }

    public void add_student(String student_name, int student_grade) {
        this.student_names.add(student_name);
        this.grades.add(student_grade);
    }

    public void change_grade(String student_name, int grade) {
        int i = student_name.indexOf(student_name);
        this.grades.set(i, grade);
    }

    public ArrayList<String> print_names(String l_grade) {
        ArrayList<String> students = new ArrayList<>();
        if (l_grade == "F") {
            for (int i = 0; i < get_student_names().size(); i++) {
                if (grades.get(i) < 60) {
                    students.add(get_student_names().get(i));
                }
            }
            System.out.print("Students with " + l_grade + " grade:");
            for (String student : students) {
                System.out.print(student + " ");
            }
            System.out.println();

            return students;

        } else if (l_grade == "C") {
            for (int i = 0; i < get_student_names().size(); i++) {
                if (grades.get(i) >= 60 && grades.get(i) < 75) {
                    students.add(get_student_names().get(i));
                }
            }
            System.out.print("Students with " + l_grade + "  grade:");
            for (String student : students) {
                System.out.print(student + " ");
            }
            System.out.println();

            return students;

        } else if (l_grade == "B") {
            for (int i = 0; i < get_student_names().size(); i++) {
                if (grades.get(i) >= 75 && grades.get(i) < 90) {
                    students.add(get_student_names().get(i));
                }
            }
            System.out.print("Students with " + l_grade + "  grade:");
            for (String student : students) {
                System.out.print(student + " ");
            }
            System.out.println();

            return students;

        } else if (l_grade == "A") {
            for (int i = 0; i < get_student_names().size(); i++) {
                if (grades.get(i) >= 90 && grades.get(i) <= 100) {
                    students.add(get_student_names().get(i));
                }
            }
            System.out.print("Students with " + l_grade + "  grade:");
            for (String student : students) {
                System.out.print(student + " ");
            }
            System.out.println();

            return students;
        }
        return students;
    }

        // Here is the print method which prints course name, number of students, and their grades
        public String toString () {
            System.out.println("Course Name: " + get_course_name() + "\n" +
                    "Student Number: " + get_number_of_students() + "\n");
            for (int i = 0; i < get_student_names().size(); i++) {
                System.out.print(get_student_names().get(i) + ": " + get_grades().get(i));
                System.out.println();
            }
            return ("Course Name: " + get_course_name() + "\n" +
                    "Student Number: " + get_number_of_students() + "\n");
        }
    }