package main.java.datastructures.queues;

public class StaticQueue<T> {

    private final T[] elements;
    private int first;
    private int last;
    private int size;

    public StaticQueue(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    public StaticQueue() {
        this(10);
    }

    public boolean enqueue(T element) {
        if (this.isFull()) return false;
        this.elements[this.last] = element;
        last = (last + 1) % this.elements.length;
        size++;
        return true;
    }

    public T dequeue() {
        if (this.isEmpty()) return null;
        T element = this.elements[this.first];
        elements[this.first] = null;
        first = (first + 1) % elements.length;
        size--;
        return element;
    }

    public T peek() {
        if (this.isEmpty()) return null;
        return this.elements[this.first];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

}
