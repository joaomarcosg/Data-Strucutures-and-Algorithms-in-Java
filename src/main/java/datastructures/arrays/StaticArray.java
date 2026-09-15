package main.java.datastructures.arrays;

import java.util.Arrays;

public class StaticArray<T> {
    private final T[] elements;

    public StaticArray(int capacity) {
        this.elements =  (T[]) new Object[capacity];
    }

    public StaticArray() {this(10);}

    public void printElements() {
        for (T n : elements) {
            IO.print(n);
        }
    }

    public int  size() {
        return elements.length;
    }

}
