package solutions;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;

public class GroupAnagramsTest {
    @Test
    public void test_case_1() {
        // ["eat","tea","tan","ate","nat","bat"] -> [["eat","tea","ate"],["bat"],["tan","nat"]]
        var input = new String[]{"eat","tea","tan","ate","nat","bat"};
        var solution = new GroupAnagrams();
        var result = solution.groupAnagrams(input);
        var expected = List.of(
            List.of("eat", "tea", "ate"),
            List.of("bat"),
            List.of("tan", "nat")
        );
        assertThat(result, is(equalTo(expected)));
    }
}
