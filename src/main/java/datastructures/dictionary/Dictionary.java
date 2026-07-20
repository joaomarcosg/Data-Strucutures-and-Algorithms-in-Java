package main.java.datastructures.dictionary;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary<K, T> {

    private final Map<K, T> map = new HashMap<>();

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public T put(K key, T value) {
        return map.put(key, value);
    }

    public T remove(K key) {
        return map.remove(key);
    }

    public T get(K key) {
        return map.get(key);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Set<K> keys() {
        return Collections.unmodifiableSet(map.keySet());
    }

}
