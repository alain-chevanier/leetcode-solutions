package solutions;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for (int count : chars) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
