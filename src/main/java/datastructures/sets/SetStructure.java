package main.java.datastructures.sets;

import java.util.HashSet;
import java.util.Set;

public class SetStructure<T> {

    private final Set<T> set = new HashSet<>();

    public boolean has(T element) {
        return set.contains(element);
    }

    public boolean add(T element) {
        return set.add(element);
    }

    public boolean delete(T element) {
        return set.remove(element);
    }

    public void clear() {
        set.clear();
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public Set<T> values() {
        return new HashSet<>(this.set);
    }
    
}
