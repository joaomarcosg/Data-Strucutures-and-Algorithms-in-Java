package main.java.datastructures.queues;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class QueueStructure<T> {
    private final Queue<T> queue = new LinkedList<>();
    
    public boolean enqueue(T element) {
        Objects.requireNonNull(element, "The element cannot be null.");
        return this.queue.offer(element);
    }

    public T dequeue() {
        if (this.queue.isEmpty()) return null;
        return this.queue.poll();
    }

    public T peek() {
        if (this.queue.isEmpty()) return null;
        return this.queue.peek();
    }
}
