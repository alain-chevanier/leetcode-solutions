package solutions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DetonamteMaximumBombsSolutionTest {
    @Test
    public void test_case_1() {
        var bombsProblem = new DetonateMaximumBombsSolution();
        // [[2,1,3],[6,1,4]] -> 2
        var bombs = new int[][] {
            new int[] {2, 1, 3},
            new int[] {6, 1, 4}
        };
        int count = bombsProblem.maximumDetonation(bombs);
        assertThat(count, is(2));
    }

    @Test
    public void test_case_2() {
        var bombsProblem = new DetonateMaximumBombsSolution();
        // [[1,1,5],[10,10,5]] -> 1
        var bombs = new int[][] {
            new int[] {1, 1, 5},
            new int[] {10, 10, 5}
        };
        int count = bombsProblem.maximumDetonation(bombs);
        assertThat(count, is(1));
    }

    @Test
    public void test_case_3() {
        var bombsProblem = new DetonateMaximumBombsSolution();
        // [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]] -> 5
        var bombs = new int[][] {
            new int[] {1, 2, 3},
            new int[] {2, 3, 1},
            new int[] {3, 4, 2},
            new int[] {4, 5, 3},
            new int[] {5, 6, 4}
        };
        int count = bombsProblem.maximumDetonation(bombs);
        assertThat(count, is(5));
    }

    @Test
    void test_case_4() {
        var bombsProblem = new DetonateMaximumBombsSolution();
        // [[1,1,100000],[100000,100000,1]] -> 1
        var bombs = new int[][] {
            new int[] {1,1,100000},
            new int[] {100000,100000,1}
        };
        int count = bombsProblem.maximumDetonation(bombs);
        assertThat(count, is(1));
    }

    @Test
    void test_case_5() {
        var bombsProblem = new DetonateMaximumBombsSolution();
        // [[4,4,3],[4,4,3]] -> 2
        var bombs = new int[][] {
            new int[] {4,4,3},
            new int[] {4,4,3}
        };
        int count = bombsProblem.maximumDetonation(bombs);
        assertThat(count, is(2));
    }
}
