package solutions;

import java.util.HashMap;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var numToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            // have we seen the difference before?
            if (numToIndex.containsKey(diff)) {
                return new int[]{numToIndex.get(diff), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

}
