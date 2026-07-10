package main.java.datastructures.stack;

import java.util.Objects;
import java.util.Stack;

public class StackStructure<T> {
    private final Stack<T> stack = new Stack<>();

    public StackStructure() {}

    public boolean push(T element) {
        Objects.requireNonNull(element);
        this.stack.push(element);
        return true;
    }

    public T pop() {
        if (this.stack.isEmpty()) return null;
        return this.stack.pop();
    }

    public T peek() {
        if (this.stack.isEmpty()) return null;
        return this.stack.peek();
    }

}
