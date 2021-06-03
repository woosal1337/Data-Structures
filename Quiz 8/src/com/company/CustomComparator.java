package com.company;

import java.util.Comparator;

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1>o2) return 1;
        if(o1<o2) return -1;
        return 0;
    }
}