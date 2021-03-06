package interview.algorithm.easy.questions;

/**
 * Given two strings s and t which consist of only lowercase letters.
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * Find the letter that was added in t.
 * Example:
 * Input:
 * s = "abcd"
 * t = "abcde"
 * Output:
 * e
 * Explanation:
 * 'e' is the letter that was added.
 * Created by zhouxuan on 2016/12/8.
 */
public interface FindTheDifference {
    char findTheDifference(String s, String t);
}
