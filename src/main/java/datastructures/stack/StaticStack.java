package main.java.datastructures.stack;

public class StaticStack<T> {

    private final T[] elements;
    private int len;

    public StaticStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.len = 0;
    }

    public StaticStack() {
        this(10);
    }

    public boolean push(T element) {
        if (this.isFull()) return false;
        this.elements[this.len++] = element;
        return true;
    }

    public T pop() {
        if (this.isEmpty()) return null;
        this.len--;
        T element = this.elements[this.len];
        this.elements[this.len] = null;
        return element;
    }

    public T peek() {
        if (this.isEmpty()) return null;
        return this.elements[this.len - 1];
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public int size() {
        return this.len;
    }

    public boolean isFull() {
        return this.len == this.elements.length;
    }

}
