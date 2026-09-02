package test.java.datastructures.recursion;

import main.java.datastructures.recursion.Fibonacci;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @Test
    @DisplayName("Should return base cases to n = 0 and n = 1")
    void shouldReturnBaseCases() {
        assertEquals(0, Fibonacci.getNthFibonacci(0));
        assertEquals(1, Fibonacci.getNthFibonacci(1));
    }

    @Test
    @DisplayName("Should calculate correctly the first Fibonacci numbers ")
    void shouldCalculateFirstFibonacciNumbers() {
        assertEquals(1, Fibonacci.getNthFibonacci(2));
        assertEquals(2, Fibonacci.getNthFibonacci(3));
        assertEquals(3, Fibonacci.getNthFibonacci(4));
        assertEquals(5, Fibonacci.getNthFibonacci(5));
        assertEquals(8, Fibonacci.getNthFibonacci(6));
    }
}
