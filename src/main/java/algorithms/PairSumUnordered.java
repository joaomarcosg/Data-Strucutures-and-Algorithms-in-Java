package main.java.algorithms;

import java.util.HashMap;
import java.util.Map;

public class PairSumUnordered {
    public static int[] findPairSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[]{};

        Map<Integer, Integer> visitedNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            if (visitedNumbers.containsKey(complement)) return new int[]{complement, currentNum};

            visitedNumbers.put(complement, i);
        }

        return new int[]{};
    }
}
