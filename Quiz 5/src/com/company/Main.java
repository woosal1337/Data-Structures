package com.company;

import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static <T> void reverseStack(Stack<T> stack) {
        if (stack.isEmpty()) {
        return;
}
        T bottom = popBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
}
    private static <T> T popBottom(Stack<T> stack) {
        T top = stack.pop();
        if (stack.isEmpty()) {
        return top;
}       else {
        T bottom = popBottom(stack);
        stack.push(top);
        return bottom;
}
}
    private static <T> void printStack(Stack<T> stack){
        Iterator<T> iterator = stack.iterator();
        while (iterator.hasNext()) {
        T t = (T) iterator.next();
        System.out.println(t);
}
}
    public static void main(String[] args) {
        Main reverse = new Main();
        Stack<String> string_stack = new Stack<>();
        System.out.println("Reversed Order Printing:");
        string_stack.push("a");
        string_stack.push("b");
        string_stack.push("c");
        string_stack.push("d");
        string_stack.push("e");
        string_stack.push("f");
        string_stack.push("g");
        string_stack.push("h");
        reverse.reverseStack(string_stack);
        printStack(string_stack);
        System.out.println("\nFinal Stack:");
        System.out.println(string_stack);
}
}