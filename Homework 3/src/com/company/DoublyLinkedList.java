package com.company;

import java.util.ArrayList;

public class DoublyLinkedList<E> {
    public static class Node<E> {
        private E item;
        private Node<E> prev;

        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            item = e;
            prev = p;
            next = n;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    public Node<E> head;

    public Node<E> tail;

    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.setNext(tail);
    }

    public DoublyLinkedList(E[] initList) {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.setNext(tail);
        for (E el : initList) {
            add(el);
        }
    }

    public int size() {
        return size;
    }

    public void add(E item) {
        if (size == 0) {
            Node<E> newNode = new Node<E>(item, head, tail);
            head.setNext(newNode);
            tail.setPrev(newNode);
            newNode.setNext(tail);
            newNode.setPrev(head);
        } else {
            Node<E> newnode = new Node<E>(item, tail.getPrev(), tail);
            tail.getPrev().setNext(newnode);
            newnode.setPrev(tail.getPrev());
            tail.setPrev(newnode);
            newnode.setNext(tail);
        }
        size++;
    }

    public int indexOf(E value) {
        Node<E> walk = head.getNext();
        for (int i = 0; i < size; i++) {
            if (walk.getItem() == value) {
                return i;
            }
            walk = walk.getNext();
        }
        return -1;
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> walk = head.getNext();
            E itemToReturn = null;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    itemToReturn = walk.item;
                    break;
                }
                walk = walk.getNext();
            }
            return itemToReturn;
        }
    }

    public void pop() {
        Node<E> itemToRemove = tail.getPrev();
        Node<E> itemToBeLast = itemToRemove.getPrev();
        itemToBeLast.setNext(tail);
        tail.setPrev(itemToBeLast);
    }

    public void removeIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> walk = head.getNext();
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    Node<E> prevOfRemove = walk.getPrev();
                    Node<E> nextOfRemove = walk.getNext();
                    prevOfRemove.setNext(nextOfRemove);
                    nextOfRemove.setPrev(prevOfRemove);
                }
                walk = walk.getNext();
            }
        }
        size--;
    }

    public void removeElement(E value) {
        Node<E> walk = head.getNext();
        while (walk != tail) {
            if (walk.getItem() == value) {
                Node<E> prevOfRemove = walk.getPrev();
                Node<E> nextOfRemove = walk.getNext();
                prevOfRemove.setNext(nextOfRemove);
                nextOfRemove.setPrev(prevOfRemove);
            }
            walk = walk.getNext();
        }
    }

    public void set(int index, E value) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> walk = head.getNext();
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    Node<E> newPrev = walk.getPrev();
                    Node<E> newNext = walk.getNext();
                    Node<E> newNode = new Node<E>(value, newPrev, newNext);
                    newNode.setPrev(newPrev);
                    newPrev.setNext(newNode);
                    newNode.setNext(newNext);
                    newNext.setPrev(newNode);
                }
                walk = walk.getNext();
            }
        }
    }

    public void printList() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head.getNext();
        while (walk != tail) {
            sb.append(walk.getItem());
            walk = walk.getNext();
            if (walk != tail)
                sb.append(", ");
        }
        sb.append(")");
        System.out.println(sb.toString());
    }
}
