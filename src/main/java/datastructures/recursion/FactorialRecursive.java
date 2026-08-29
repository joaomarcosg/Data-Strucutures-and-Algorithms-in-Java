package main.java.datastructures.recursion;

public class FactorialRecursive {

    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The number must be greater than or equal to zero ");
        }
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
