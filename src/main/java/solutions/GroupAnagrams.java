package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        var keyToStrings = new HashMap<String, List<String>>();
        for (String s : strs) {
            int[] frequencies = calcCharactersFrequency(s);
            String hashCode = Arrays.toString(frequencies);
            keyToStrings.putIfAbsent(hashCode, new LinkedList<>());
            keyToStrings.get(hashCode).add(s);
        }

        return keyToStrings.entrySet()
                            .stream()
                            .map(entry -> entry.getValue())
                            .collect(Collectors.toList());
    }

    int[] calcCharactersFrequency(String str) {
        int[] frequencies = new int[26];
        for (char c : str.toCharArray()) {
            frequencies[c - 'a']++;
        }
        return frequencies;
    }
}
