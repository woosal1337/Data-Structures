/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.company;

/**
 * A basic doubly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DoublyLinkedList<E> {

    public static class Node<E> {

        private E element;

        private Node<E> prev;

        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
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

    public Node<E> header;

    public Node<E> trailer;

    public int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {

        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }


    public void swapElements(Node<E> x, Node<E> y) {

        if (x.getPrev() == y | x.getNext() == y) {

          // First two condition check
          if (x.getPrev() == y) {
                Node<E> temporary_node = new Node<>(x.getElement(), x.getPrev(), x.getNext());

                x.getPrev().setNext(y);
                x.setPrev(y.getPrev());
                x.getNext().setPrev(y);
                x.setNext(y.getNext());
                y.getPrev().setNext(x);
                y.setPrev(temporary_node.getPrev());
                y.getNext().setPrev(x);
                y.setNext(temporary_node.getNext());
            }

          // Second condition check
          else if (x.getNext() == y) {
                Node<E> temporary_node = new Node<>(y.getElement(), y.getPrev(), y.getNext());

                y.getPrev().setNext(x);
                y.setPrev(x.getPrev());
                y.getNext().setPrev(x);
                y.setNext(x.getNext());
                x.getPrev().setNext(y);
                x.setPrev(temporary_node.getPrev());
                x.getNext().setPrev(y);
                x.setNext(temporary_node.getNext());

            }
        // Final condition check
        }

        else {
            Node<E> temporary_node = new Node<>(y.getElement(), y.getPrev(), y.getNext());

            y.getPrev().setNext(x);
            y.setPrev(x.getPrev());
            y.setNext(x.getNext());
            y.getNext().setPrev(x);
            x.getPrev().setNext(y);
            x.getNext().setPrev(y);
            x.setNext(temporary_node.getNext());
            x.setPrev(temporary_node.getPrev());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}