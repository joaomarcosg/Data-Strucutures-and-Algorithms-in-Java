package test.java.datastructures.stack;

import main.java.datastructures.stack.StaticStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticStackTest {
    private StaticStack<Integer> stack;

    @BeforeEach
    void setUp() {
       stack = new StaticStack<>(4);
    }

    @Test
    @DisplayName("Should start a empty stack and with a zero size")
    void shouldStartEmpty() {
        assertTrue((stack.isEmpty()));
        assertFalse(stack.isFull());
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("Should stack the elements correctly and update the size")
    void shouldPushElements() {
        assertTrue(stack.push(5));
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(5, stack.peek());

        assertTrue(stack.push(8));
        assertEquals(2, stack.size());
        assertEquals(8, stack.peek());
    }

    @Test
    @DisplayName("Should unstack the elements in LIFO order")
    void shouldPopElementsInLifoOrder() {
        stack.push(5);
        stack.push(8);
        stack.push(11);
        stack.push(15);

        assertEquals(15, stack.pop());
        assertEquals(3, stack.size());

        assertEquals(11, stack.pop());
        assertEquals(2, stack.size());

        assertEquals(8, stack.pop());
        assertEquals(1, stack.size());

        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
    }

}