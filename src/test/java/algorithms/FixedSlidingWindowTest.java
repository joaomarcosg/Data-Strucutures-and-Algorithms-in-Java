package test.java.algorithms;

import main.java.algorithms.FixedSlidingWindow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixedSlidingWindowTest {

    @Test
    @DisplayName("Should find the maximum sum in an array of positives numbers")
    void findMaxSumInStandardArray() {
        int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        int result = FixedSlidingWindow.maxSubarraySum(nums, k);

        assertEquals(39, result, "The maximum sum for k = 4 should be 39");
    }

    @Test
    @DisplayName("Should run smoothly when the array contains negative numbers")
    void shouldWorkWithNegativeNumbers() {
        int[] nums = {-1, -2, -3, 4, -1, 5, -2};
        int k = 2;

        int result = FixedSlidingWindow.maxSubarraySum(nums, k);

        assertEquals(4, result, "The maximum sum for k = 2 with negatives should be 4");
    }

}
