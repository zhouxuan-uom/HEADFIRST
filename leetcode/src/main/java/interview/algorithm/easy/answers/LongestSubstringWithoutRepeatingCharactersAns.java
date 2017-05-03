package interview.algorithm.easy.answers;

import interview.algorithm.easy.questions.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by zhouxuan on 2017/4/7.
 */
public class LongestSubstringWithoutRepeatingCharactersAns implements LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int leftIndex = 0;
        int rightIndex = 0;
        int longestLeftIndex = 0;
        int longestRightIndex = 0;
        Set<Character> characters = new HashSet<Character>();
        while (rightIndex < s.length()) {

        }
        return 0;
    }
}
