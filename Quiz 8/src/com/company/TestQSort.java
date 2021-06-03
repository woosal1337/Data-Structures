package com.company;


import java.util.Random;
import java.util.Comparator;
import java.util.LinkedList;

public class TestQSort {


    public static void main(String[] args) {
        // Initializations of the variables

        QuickSort customQS = new QuickSort();
        LinkedQueue<Integer> customQ = new LinkedQueue<>();
        CustomComparator customC = new CustomComparator();



        Random customRand = new Random();
        // Creating a loop of 100 random integers
        for (int i = 0; i < 100; i++) {
            customQ.enqueue(customRand.nextInt(100));
        }

        QuickSort.quickSort(customQ, customC);


        // Printing out the results:
        System.out.println("Total Enqueue Count:" + QuickSort.numberOfEnqueue +
                "\nTotal Dequeue Count:" + QuickSort.numberOfDeque +
                "\nTotal Number of Recursions:" + QuickSort.numberOfRecursiveCalls);
    }
}
