package main.java.datastructures.linkedlist;

public class CircularLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(element);

        if (size == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        } else  {
            Node<T> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
            if (index == size) {
                tail = newNode;
            }
        }
        size++;
    }

    public T removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        T removedData;

        if (index == 0) {
            removedData = head.data;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
        } else {
            Node<T> prev = getNode(index - 1);
            Node<T> toRemove = prev.next;
            removedData = toRemove.data;
            prev.next = toRemove.next;
            if (toRemove == tail) {
                tail = prev;
            }
        }
        size--;
        return removedData;
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}
}
