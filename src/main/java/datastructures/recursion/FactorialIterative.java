package main.java.datastructures.recursion;

public class FactorialIterative {

    public static long factorial(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The number must be greater than or equal to zero ");
        }
        long total = 1;
        for (int n = number; n > 1; n--) {
            total *= n;
        }
        return total;
    }
}
