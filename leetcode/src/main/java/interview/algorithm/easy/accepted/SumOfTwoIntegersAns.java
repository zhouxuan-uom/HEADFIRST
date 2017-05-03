package interview.algorithm.easy.accepted;

import interview.algorithm.easy.questions.SumOfTwoIntegers;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 * Created by zhouxuan on 2016/12/8.
 */
public class SumOfTwoIntegersAns implements SumOfTwoIntegers {
    public int getSum(int a, int b) {
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);
        for (int i = 0; i < binaryA.length(); i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println((Integer.toBinaryString(22)));
    }
}
