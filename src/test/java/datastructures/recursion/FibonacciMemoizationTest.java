package test.java.datastructures.recursion;

import main.java.datastructures.recursion.FibonacciMemoization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciMemoizationTest {

    @Test
    @DisplayName("Should return base cases to n = 0 and n = 1")
    void shouldReturnBaseCases() {
        assertEquals(0, FibonacciMemoization.getNthFibonacci(0));
        assertEquals(1, FibonacciMemoization.getNthFibonacci(1));
    }

    @Test
    @DisplayName("Should calculate correctly the first terms of sequence")
    void shouldCalculateFirstFibonacciNumbers() {
        assertEquals(1, FibonacciMemoization.getNthFibonacci(2));
        assertEquals(2, FibonacciMemoization.getNthFibonacci(3));
        assertEquals(3, FibonacciMemoization.getNthFibonacci(4));
        assertEquals(5, FibonacciMemoization.getNthFibonacci(5));
        assertEquals(8, FibonacciMemoization.getNthFibonacci(6));
    }

}
