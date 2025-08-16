package solutions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContainsDuplicateTest {
    @Test
    public void test_case_1() {
        var solution = new ContainsDuplicate();
        // [1,2,3,1] -> true
        int[] nums = new int[] {1, 2, 3, 1};
        boolean result = solution.hasDuplicate(nums);
        assertThat(result, is(true));
    }

    @Test
    public void test_case_2() {
        var solution = new ContainsDuplicate();
        // [1,2,3,4] -> false
        int[] nums = new int[] {1, 2, 3, 4};
        boolean result = solution.hasDuplicate(nums);
        assertThat(result, is(false));
    }

    @Test
    public void test_case_3() {
        var solution = new ContainsDuplicate();
        // [1,1,1] -> true
        int[] nums = new int[] {1, 1, 1};
        boolean result = solution.hasDuplicate(nums);
        assertThat(result, is(true));
    }

    @Test
    public void test_case_4() {
        var solution = new ContainsDuplicate();
        // [] -> false
        int[] nums = new int[] {};
        boolean result = solution.hasDuplicate(nums);
        assertThat(result, is(false));
    }
}
