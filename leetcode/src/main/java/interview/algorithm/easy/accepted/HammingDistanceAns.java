package interview.algorithm.easy.accepted;

import interview.algorithm.easy.questions.HammingDistance;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * Created by zhouxuan on 2016/12/30.
 */
public class HammingDistanceAns implements HammingDistance {
    public int hammingDistance(int x, int y) {
        int result = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                result++;
            }
            x = x / 2;
            y = y / 2;
        }
        return result;
    }
}
