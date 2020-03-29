package linkedlist;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private int size;
    private Node first;
    private Node last;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        return first.element;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        return last.element;
    }

    public void add(T item) {
        if (isEmpty()) {
            first = last;
        }
        Node oldNode = last;
        last = new Node(item, oldNode, null);
        oldNode.next = last;
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        T item = last.element;
        Node prev = last.previous;
        last.previous = null;
        last = prev;
        size--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public T get(int index) {
        Node current = checkProximalEnd(index);
        return current.element;
    }

    void set(int index, T x) {
        Node current = checkProximalEnd(index);
        current.element = x;
    }

    private Node checkProximalEnd(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        if (index < size / 2) {
            int currentIndex = 0;
            current = first;
            while (currentIndex < index) {
                current = current.next;
                currentIndex++;
            }
        } else {
            int currentIndex = size - 1;
            current = last;
            while (currentIndex > index) {
                current = current.next;
                currentIndex--;
            }
        }
        return current;
    }

    int indexOf(T x) {
        Node current = first;
        int currentIndex = 0;
        while (current != null && !current.element.equals(x)) {
            current = current.next;
            currentIndex++;
        }
        return current != null ? currentIndex : -1;
    }

    boolean contains(T x) {
        return indexOf(x) > -1;
    }

    private class Node {
        private T element;
        private Node previous;
        private Node next;

        public Node(T element, Node previous, Node next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
    }
}
