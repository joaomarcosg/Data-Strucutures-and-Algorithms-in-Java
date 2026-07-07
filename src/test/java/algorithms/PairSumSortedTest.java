package test.java.algorithms;

import main.java.algorithms.PairSumSorted;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PairSumSortedTest {

    @Test
    @DisplayName("Should find the pair sum equals the target in a sorted array")
    void findPairSumInSortedArray() {
        int[] nums = {-5, -2, 3, 4, 6};
        int target = 7;

        int[] result = PairSumSorted.findPairSum(nums, target);

        int[] expected = {3, 4};
        assertArrayEquals(expected, result, "The pair is not equal to the target");
    }
}
