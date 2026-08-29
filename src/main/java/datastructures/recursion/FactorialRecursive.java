package main.java.datastructures.recursion;

public class FactorialRecursive {

    public static long factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
