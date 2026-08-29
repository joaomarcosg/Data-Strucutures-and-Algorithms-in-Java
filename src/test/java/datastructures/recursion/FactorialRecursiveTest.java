package test.java.datastructures.recursion;

import main.java.datastructures.recursion.FactorialIterative;
import main.java.datastructures.recursion.FactorialRecursive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialRecursiveTest {

    @Test
    @DisplayName("Should calculate factorial of 0 as 1")
    void shouldReturnOneForZero() {
        long result = FactorialRecursive.factorial(0);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Should calculate factorial of small positive numbers")
    void shouldCalculateFactorialForSmallNumbers() {
        assertEquals(1, FactorialRecursive.factorial(1));
        assertEquals(2, FactorialRecursive.factorial(2));
        assertEquals(6, FactorialRecursive.factorial(3));
        assertEquals(24, FactorialRecursive.factorial(4));
        assertEquals(120, FactorialRecursive.factorial(5));
    }
}
