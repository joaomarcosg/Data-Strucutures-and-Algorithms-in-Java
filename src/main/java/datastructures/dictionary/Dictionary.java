package main.java.datastructures.dictionary;

import java.util.*;

public class Dictionary<K, T> implements Iterable<Map.Entry<K, T>> {

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

    public Collection<T> values() {
        return List.copyOf(map.values());
    }

    public Set<Map.Entry<K, T>> entries() {
        return Set.copyOf(map.entrySet());
    }

    @Override
    public Iterator<Map.Entry<K, T>> iterator() {
        return map.entrySet().iterator();
    }

    @Override
    public String toString() {
        return map.toString();
    }

}
