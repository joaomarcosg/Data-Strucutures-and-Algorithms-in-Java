package main.java.datastructures.hashes;

import java.util.Objects;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    private Node<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Initial capacity must be greater than zero");
        this.table = (Node<K, V>[]) new Node[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        int h = Objects.hashCode(key);
        h ^= (h >>> 16);
        return h & 0x7fffffff;
    }

    private int indexFor(K key, int capacity) {
        return hash(key) % capacity;
    }

    public V put(K key, V value) {
        Objects.requireNonNull(key, "Key cannot be null");

        int index = indexFor(key, table.length);
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }

        table[index] = new Node<>(key, value, table[index]);
        size++;

        if (loadFactor() > LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        return null;
    }

    public V get(K key) {
        Objects.requireNonNull(key, "Key cannot be null");

        int index = indexFor(key, table.length);
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public V remove(K key) {
        Objects.requireNonNull(key, "Key cannot be null");

        int index = indexFor(key, table.length);
        Node<K, V> current = table[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size --;
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] oldTable = table;
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[oldTable.length * 2];

        for (Node<K, V> head : oldTable) {
            Node<K, V> current = head;
            while (current != null) {
                Node<K, V> next = current.next;
                int newIndex = indexFor(current.key, newTable.length);
                current.next = newTable[newIndex];
                newTable[newIndex] = current;
                current = next;
            }
        }

        this.table = newTable;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private double loadFactor() {
        return (double) size / table.length;
    }

}
