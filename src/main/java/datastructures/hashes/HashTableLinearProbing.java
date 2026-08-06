package main.java.datastructures.hashes;

import java.util.Objects;

public class HashTableLinearProbing<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.5;

    private static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    @SuppressWarnings("rawtypes")
    private static final Entry TOMBSTONE = new Entry<>(null, null);

    private Entry<K, V>[] table;
    private int size;
    private int usedSlots;

    @SuppressWarnings("unchecked")
    public HashTableLinearProbing() {
        this.table =(Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        this.size = 0;
        this.usedSlots = 0;
    }

    @SuppressWarnings("unchecked")
    public HashTableLinearProbing(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than zero.");
        }
        this.table = (Entry<K, V>[]) new Entry[initialCapacity];
        this.size = 0;
        this.usedSlots = 0;
    }

    private int hash(K key) {
        int h = Objects.hashCode(key);
        h ^= (h >>> 16);
        return h & 0x7fffffff;
    }

    private int indexFor(K key, int capacity) {
        return hash(key) % capacity;
    }

    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        Objects.requireNonNull(key, "Key cannot be null.");

        if (usedSlots >= table.length * LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int capacity = table.length;
        int index = indexFor(key, capacity);
        int firstTombstone = -1;

        for (int probe = 0; probe < capacity; probe++) {
            int currentIndex = (index + probe) % capacity;
            Entry<K, V> current = table[currentIndex];

            if (current == null) {
                int insertIndex = (firstTombstone != -1) ? firstTombstone : currentIndex;
                table[insertIndex] = new Entry<>(key, value);
                size++;
                if (firstTombstone == -1) {
                    usedSlots++;
                }
                return null;
            }

            if (current == TOMBSTONE) {
                if (firstTombstone == -1) {
                    firstTombstone = currentIndex;
                }
                continue;
            }

            if (current.key.equals(key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }

        }

        resize();
        return put(key, value);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;

        table = (Entry<K, V>[]) new Entry[oldTable.length * 2];
        size = 0;
        usedSlots = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null && entry != TOMBSTONE) {
                put(entry.key, entry.value);
            }
        }
    }

}
