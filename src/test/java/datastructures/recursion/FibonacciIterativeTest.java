package test.java.datastructures.recursion;

import main.java.datastructures.recursion.FibonacciIterative;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciIterativeTest {

    @Test
    @DisplayName("Should return base cases to n <= 0 and n == 1")
    void shouldReturnBaseCases() {
        assertEquals(0, FibonacciIterative.getNthFibonacci(-5));
        assertEquals(0, FibonacciIterative.getNthFibonacci(0));
        assertEquals(1, FibonacciIterative.getNthFibonacci(1));
    }

    @Test
    @DisplayName("Should calculate correctly the first Fibonacci numbers")
    void shouldCalculateFirstFibonacciNumbers() {
        assertEquals(1, FibonacciIterative.getNthFibonacci(2));
        assertEquals(2, FibonacciIterative.getNthFibonacci(3));
        assertEquals(3, FibonacciIterative.getNthFibonacci(4));
        assertEquals(5, FibonacciIterative.getNthFibonacci(5));
        assertEquals(8, FibonacciIterative.getNthFibonacci(6));
    }

}
