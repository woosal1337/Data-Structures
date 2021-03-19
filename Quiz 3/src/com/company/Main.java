package com.company;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<String> list_int = new DoublyLinkedList<>() ;

        list_int.addFirst("Hasan");
        list_int.addLast("Ali");
        list_int.addLast("Veli");
        list_int.addLast("Can");
        list_int.addLast("Akin");
        String ss = list_int.toString() ;
        System.out.println(ss);


        // Changes the first element with the last
        list_int.swapElements(list_int.header.getNext(),list_int.trailer.getPrev());

        // Changes the first element with the second
        list_int.swapElements(list_int.header.getNext(),list_int.header.getNext().getNext());

        // Changes the second element with the first
        list_int.swapElements(list_int.header.getNext().getNext(),list_int.header.getNext());

        ss = list_int.toString() ;
        System.out.print(ss);
    }
}
