package main.java.datastructures.recursion;

public class Fibonacci {

    public static int getNthFibonacci(int n) {
        if (n < 1) return 0;
        if (n <= 2) return 1;

        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }
}
