package test.java.algorithms;

import main.java.algorithms.IsPalindrome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPalindromeTest {

    @Test
    @DisplayName("Should return true if the word or phrase is a palindrome")
    void checkPalindrome() {
        String text = "Anotaram a data da maratona";

        boolean result = IsPalindrome.checkString(text);

        assertTrue(result, "The string is a palindrome");
    }
}
