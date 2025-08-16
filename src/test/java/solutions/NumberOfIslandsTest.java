package solutions;

// generate a test class for NumberOfIslands.java
// similar to ContainsDuplicateTest.java

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NumberOfIslandsTest {
    @Test
    public void test_case_1() {
        // Input:
        // [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
        // Solution: 3
        char[][] grid = new char[][] {
           {'1','1','0','0','0'},
           {'1','1','0','0','0'},
           {'0','0','1','0','0'},
           {'0','0','0','1','1'}
        };
        var solution = new NumberOfIslands();
        int result = solution.numIslands(grid);
        assertThat(result, is(3));
    }

    @Test
    public void test_case_2() {
        // Input:
        // [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
        // Solution: 1
        char[][] grid = new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        var solution = new NumberOfIslands();
        int result = solution.numIslands(grid);
        assertThat(result, is(1));
    }
}
