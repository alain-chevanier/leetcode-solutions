package solutions;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidAnagramTest {
    @Test
    public void test_case_1() {
        var solution = new ValidAnagram();
        // "anagram", "nagaram" -> true
        boolean result = solution.isAnagram("anagram", "nagaram");
        assertThat(result, is(true));
    }

    @Test
    public void test_case_2() {
        var solution = new ValidAnagram();
        // "rat", "car" -> false
        boolean result = solution.isAnagram("rat", "car");
        assertThat(result, is(false));
    }

    @Test
    public void test_case_3() {
        var solution = new ValidAnagram();
        // "listen", "silent" -> true
        boolean result = solution.isAnagram("listen", "silent");
        assertThat(result, is(true));
    }

    @Test
    public void test_case_4() {
        var solution = new ValidAnagram();
        // "hello", "world" -> false
        boolean result = solution.isAnagram("hello", "world");
        assertThat(result, is(false));
    }

    @Test
    public void test_case_5() {
        var solution = new ValidAnagram();
        // "aabbcc", "abcabc" -> false
        boolean result = solution.isAnagram("aabbcc", "abc");
        assertThat(result, is(false));
    }

    @Test
    public void test_case_6() {
        var solution = new ValidAnagram();
        // "aaaa", "aaa" -> true
        boolean result = solution.isAnagram("aaaa", "aaa");
        assertThat(result, is(false));
    }
}
