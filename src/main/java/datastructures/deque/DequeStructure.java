package main.java.datastructures.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class DequeStructure<T> {
    private Deque<T> deque = new ArrayDeque<>();

    public boolean addFront(T element) {
        Objects.requireNonNull(element, "The element cannot be null");
        this.deque.addFirst(element);
        return true;
    }

    public boolean addRear(T element) {
        Objects.requireNonNull(element, "The element cannot be null");
        this.deque.addLast(element);
        return true;
    }

    public T removeFront() {
        return this.deque.pollFirst();
    }

    public T removeRear() {
        return this.deque.pollLast();
    }

    public boolean isEmpty() {
        return this.deque.isEmpty();
    }

    public int size() {
        return this.deque.size();
    }
}
