package main.java.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray<T>{

    private List<T> elements = new ArrayList<>();

    public void insert(int index, T element) {
        elements.add(index, element);
    }

    public void insertLast(T element) {
        elements.addLast(element);
    }

    public void insertFirst(T element) {
        elements.addFirst(element);
    }

    public void remove(int index) {
        elements.remove(index);
    }

    public void removeFirst() {
        elements.removeFirst();
    }

    public void removeLast() {
        elements.removeLast();
    }

}
