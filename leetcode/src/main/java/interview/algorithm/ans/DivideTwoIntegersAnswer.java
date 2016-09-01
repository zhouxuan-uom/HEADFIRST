package interview.algorithm.ans;

import interview.algorithm.DivideTwoIntegers;

/**
 * Created by zhouxuan on 16/8/24.
 */
public class DivideTwoIntegersAnswer implements DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend < 0) {
            dividend = -dividend;
            sign = -sign;
        }
        if (divisor < 0) {
            divisor = -divisor;
            sign = -sign;
        }
        int result = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }
        return sign < 0 ? -result : result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divide = new DivideTwoIntegersAnswer();
        System.out.println(divide.divide(-2147483648, -1));
    }
}
