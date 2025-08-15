package solutions;

import java.util.HashSet;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicateSolution {
    public boolean hasDuplicate(int[] nums) {
        var foundElements = new HashSet<Integer>();
        for (int n : nums) {
            if (foundElements.contains(n)) {
                return true;
            }
            foundElements.add(n);
        }
        return false;
    }
}
