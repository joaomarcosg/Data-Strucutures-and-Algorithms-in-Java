package main.java.algorithms;

import main.java.datastructures.deque.DequeStructure;

public class PalindromeChecker {

    public static  boolean isPalindrome(String s) {

        if (s == null) return false;

        DequeStructure<String> deque = new DequeStructure<>();
        var lowerString = s.toLowerCase();
        var isEqual = true;
        String firstChar, lastChar;

        for (int i = 0; i < s.length(); i++) {
            deque.addRear(String.valueOf(lowerString.charAt(i)));
        }

        while (deque.size() > 1 && isEqual) {
            firstChar = deque.removeFront();
            lastChar = deque.removeRear();
            if (!firstChar.equals(lastChar)) {
                isEqual = false;
            }
        }

        return isEqual;
    }

}
