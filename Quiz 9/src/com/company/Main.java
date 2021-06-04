package com.company;

import java.util.PriorityQueue;
import java.util.Iterator;

// Test Case for the following inputs:
// A = [10, 5, 2, 1, 6, 8, 3, 7]
// B = [0, 4, 7, 10, 6, 1, 2, 12, 9]
// m = 20

public class Main {

    public static void main(String[] args) {

        // Initializing the m, which stand for the condition check in the iteration below
        int m = 20;

        // Creating the first Priority Queue(PQ A)
        Integer[] first = {10, 5, 2, 1, 6, 8, 3, 7};
        PriorityQueue<Integer> PQ1 = new PriorityQueue<>();

        // Looping through the first list and adding to the first Priority Queue
        for (int num : first) {
            PQ1.add(num);
        }

        // Creating the second Priority Queue (PQ B)
        Integer[] second = {0, 4, 7, 10, 6, 1, 2, 12, 9};
        PriorityQueue<Integer> PQ2 = new PriorityQueue<>();

        // Looping through the second list and adding to the second Priority Queue
        for (int num : second) {
            PQ2.add(num);
        }

        // Iterating through both Priority Queues and checking the if equals to the 20 condition
        for (int PQ1_Nums : PQ1) {
            for (int PQ2_Nums : PQ2) {
                if (PQ1_Nums + PQ2_Nums == m) {
                    System.out.println("(" + PQ1_Nums + ", " + PQ2_Nums + ")");
                }
            }
        }

    }
}
