package solutions;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TwoSumTest {
    @Test
    public void test_case_1() {
        var solution = new TwoSum();
        // [2, 7, 11, 15], target = 9 -> [0, 1]
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        assertThat(result, is(new int[]{0, 1}));
    }

    @Test
    public void test_case_2() {
        var solution = new TwoSum();
        // [3, 2, 4], target = 6 -> [1, 2]
        int[] nums = new int[] {3, 2, 4};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        assertThat(result, is(new int[]{1, 2}));
    }

    @Test
    public void test_case_3() {
        var solution = new TwoSum();
        // [3, 3], target = 6 -> [0, 1]
        int[] nums = new int[] {3, 3};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        assertThat(result, is(new int[]{0, 1}));
    }
}
