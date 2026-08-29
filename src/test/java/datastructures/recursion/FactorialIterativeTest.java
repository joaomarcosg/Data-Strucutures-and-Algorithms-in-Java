package test.java.datastructures.recursion;

import main.java.datastructures.recursion.FactorialIterative;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialIterativeTest {

    @Test
    @DisplayName("Should calculate factorial of 0 as 1")
    void shouldReturnOneForZero() {
        long result = FactorialIterative.factorial(0);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Should calculate factorial of small positive numbers")
    void shouldCalculateFactorialForSmallNumbers() {
        assertEquals(1, FactorialIterative.factorial(1));
        assertEquals(2, FactorialIterative.factorial(2));
        assertEquals(6, FactorialIterative.factorial(3));
        assertEquals(24, FactorialIterative.factorial(4));
        assertEquals(120, FactorialIterative.factorial(5));
    }

}
