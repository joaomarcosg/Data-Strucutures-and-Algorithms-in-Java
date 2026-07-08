package test.java.datastructures.queues;

import main.java.datastructures.queues.StaticQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaticQueueTest {
    private StaticQueue<String> queue;

    @BeforeEach
    void setup() {
        queue = new StaticQueue<>(3);
    }

    @Test
    @DisplayName("Should initialize an empty queue with zero size")
    void shouldInitializeEmptyQueue() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    @DisplayName("Should enqueue elements and obey the FIFO order in dequeue")
    void shouldEnqueueAndDequeueInFifoOrder() {
        queue.enqueue("John");
        queue.enqueue("Jack");
        queue.enqueue("Camila");

        assertFalse(queue.isEmpty());
        assertTrue(queue.isFull());

        assertEquals("John", queue.dequeue());
        assertEquals("Jack", queue.dequeue());
        assertEquals("Camila", queue.dequeue());

        assertTrue(queue.isEmpty());
    }
}
