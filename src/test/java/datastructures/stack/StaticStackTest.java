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

}