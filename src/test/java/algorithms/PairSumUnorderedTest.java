package test.java.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PairSumUnorderedTest {

    @Test
    @DisplayName("Should find the pair sum equals the target in an unordered array")
    void findPairSumInAnUnorderedArray() {
        int[] nums = {3, 2, 1, 6, 4};
        int target = 6;

        int[] result = PairSumUnordered.findPairSum(nums, target);

        int[] expected = {2, 4};
        assertArrayEquals(expected, result, "The pair is not equal to the target");
    }
}
