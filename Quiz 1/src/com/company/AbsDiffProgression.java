package com.company;

public class AbsDiffProgression extends Progression {

    protected long prev;

    public AbsDiffProgression() { this(1, 2); }

    public AbsDiffProgression(long first, long second) {
        current = first;
        prev = second;}

    protected void advance() {
        long temp = current;
        current = Math.abs(prev - current);
        prev = temp; }
}