package main.java.datastructures.deque;

public class StaticDeque<T> {
    private final T[] elements;
    private int front;
    private int rear;
    private int size;

    public StaticDeque(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public StaticDeque() {
        this(10);
    }

    public boolean addFront(T element) {
        if (this.isFull()) return false;

        if (!this.isEmpty()) {
            front = (front - 1 + this.elements.length) % elements.length;
        }

        this.elements[front] = element;
        size++;
        return true;
    }

    public boolean addBack(T element) {
        if (this.isFull()) return false;

        if (!this.isEmpty()) {
            rear = (rear + 1) % elements.length;
        }

        this.elements[rear] = element;
        size++;
        return true;
    }

    public T removeFront() {
        if (this.isEmpty()) return null;

        T element = this.elements[front];
        this.elements[front] = null;

        if (this.size > 1) {
            front = (front + 1) % elements.length;
        }

        size--;
        return element;
    }

    public T removeBack() {
        if (this.isEmpty()) return null;

        T element = this.elements[rear];
        this.elements[rear] = null;

        if (this.size > 1) {
            rear =  (rear + 1) % elements.length;
        }

        size--;
        return element;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }
    
}
