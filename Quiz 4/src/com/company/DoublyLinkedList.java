package com.company;

public class DoublyLinkedList {

    public static class Node {
        private Object item;

        private Node prev;

        private Node next;

        public Node(Object e, Node p, Node n) {
            item = e;
            prev = p;
            next = n;
        }

        public Object get_item() {
            return item;
        }

        public Node get_prev() {
            return prev;
        }

        public void set_next(Node n) {
            next = n;
        }

        public Node get_next() {
            return next;
        }

        public void set_prev(Node p) {
            prev = p;
        }
    }

    public Node head;

    public Node tail;

    private int size = 0;

    public DoublyLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.set_next(tail);
    }

    public int size() {
        return size;
    }

    public void add(Object item) {
        if (size == 0) {
            Node newNode = new Node(item, head, tail);
            head.set_next(newNode);
            tail.set_prev(newNode);
            newNode.set_next(tail);
            newNode.set_prev(head);
        } else {
            Node new_node = new Node(item, tail.get_prev(), tail);
            tail.get_prev().set_next(new_node);
            new_node.set_prev(tail.get_prev());
            tail.set_prev(new_node);
            new_node.set_next(tail);
        }
        size++;
    }

    public int index_of(Object value) {
        Node jump = head.get_next();
        for (int i = 0; i < size; i++) {
            if (jump.get_item() == value) {
                return i;
            }
            jump = jump.get_next();
        }
        return -1;
    }

    public Object get_last() {
        return get(size - 1);

    }

    public Object get_first() {
        return get(0);

    }

    public Object get(int index) {
        if (index > size - 1) {
            throw new java.lang.IndexOutOfBoundsException();
        } else {
            Node walk = head.get_next();
            Object itemToReturn = null;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    itemToReturn = walk.item;
                    break;
                }
                walk = walk.get_next();
            }
            return itemToReturn;
        }
    }

    public void pop() {
        Node itemToBeRemoved = tail.get_prev();
        Node itemToBeLast = itemToBeRemoved.get_prev();
        itemToBeLast.set_next(tail);
        tail.set_prev(itemToBeLast);
    }

    public void remove_index(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node jump = head.get_next();
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    Node prevOfRemove = jump.get_prev();
                    Node nextOfRemove = jump.get_next();
                    prevOfRemove.set_next(nextOfRemove);
                    nextOfRemove.set_prev(prevOfRemove);
                }
                jump = jump.get_next();
            }
        }
    }

    public void remove_item(Object value) {
        Node jump = head.get_next();
        while (jump != tail) {
            if (jump.get_item() == value) {
                Node prevOfRemove = jump.get_prev();
                Node nextOfRemove = jump.get_next();
                prevOfRemove.set_next(nextOfRemove);
                nextOfRemove.set_prev(prevOfRemove);
            }
            jump = jump.get_next();
        }
    }

    public void set(int index, Object value) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node walk = head.get_next();
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    Node newPrev = walk.get_prev();
                    Node newNext = walk.get_next();
                    Node newNode = new Node(value, newPrev, newNext);
                    newNode.set_prev(newPrev);
                    newPrev.set_next(newNode);
                    newNode.set_next(newNext);
                    newNext.set_prev(newNode);
                }
                walk = walk.get_next();
            }
        }
    }

    public void print_list() {
        StringBuilder sb = new StringBuilder(" ");
        Node jump = head.get_next();
        while (jump != tail) {
            sb.append(jump.get_item());
            jump = jump.get_next();
            if (jump != tail)
                sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        Node walk = head.get_next();
        while (walk != tail) {
            sb.append(walk.get_item());
            walk = walk.get_next();
            if (walk != tail)
                sb.append(" ");
        }
        System.out.println(sb.toString());

        return sb.toString();
    }
}
