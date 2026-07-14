package main.java.datastructures.linkedlist;

import java.util.LinkedList;
import java.util.Objects;

public class LinkedListStructure<T> {

    private final LinkedList<T> list = new LinkedList<>();

    public LinkedListStructure() {}

    public boolean push(T element) {
        Objects.requireNonNull(element, "The element cannot be null");
        this.list.addLast(element);
        return true;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= this.list.size()) {
            throw  new IndexOutOfBoundsException();
        }
        return this.list.remove(index);
    }

    public void insert(int index, T element) {
        Objects.requireNonNull(element, "The element cannot be null");
        if (index < 0 || index > this.list.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.list.add(index, element);
    }

    public int indexOf(T element) {
        Objects.requireNonNull(element, "The element cannot be null");
        return this.list.indexOf(element);
    }

    public boolean Remove(T element) {
        Objects.requireNonNull(element, "The element cannot be null");
        return this.list.remove(element);
    }

    public T peek() {
        return this.list.peekFirst();
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

}
