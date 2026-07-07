package main.java.datastructures.stack;

public class StaticStack<T> {

    private T[] elements;
    private int len;

    public StaticStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.len = 0;
    }

    public StaticStack() {
        this(10);
    }

    private void increaseCapacity() {
        if (this.len == this.elements.length) {
            T[] newElements = (T[]) new Object[this.elements.length * 2];
            for (int i = 0; this.elements.length > i; i++) {
                newElements[i] = this.elements[i];
            }
            this.elements = newElements;
        }
    }

    public boolean push(T element) {
        this.increaseCapacity();
        if (this.len < this.elements.length) {
            this.elements[this.len++] = element;
            return true;
        }
        return false;
    }

    public T pop() {
        if (this.isEmpty()) return null;
        return this.elements[--len];
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


}
