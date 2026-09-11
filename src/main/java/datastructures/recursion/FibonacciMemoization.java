package main.java.datastructures.recursion;

import java.util.Arrays;

public class FibonacciMemoization {

    public static long getNthFibonacci(final int n) {
        if (n < 0) throw new IllegalArgumentException("Index cannot be negative");

        long[] memo = new long[n + 1];

        Arrays.fill(memo, -1);

        return getNthFibonacci(n, memo);
    }

    private static long getNthFibonacci(final int n, final long[] memo) {
        if (n <= 1) return n;

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = getNthFibonacci(n - 1, memo) + getNthFibonacci(n - 2, memo);

        return memo[n];
    }
}
