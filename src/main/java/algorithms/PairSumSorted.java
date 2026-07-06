package main.java.algorithms;

public class PairSumSorted {
    public int[] findPairSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{};
    }
}
