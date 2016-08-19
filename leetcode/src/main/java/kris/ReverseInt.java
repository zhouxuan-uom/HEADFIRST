package kris;

import java.util.List;

/**
 * Created by zhouxuan on 16/7/7.
 */
public class ReverseInt {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (x < 0) {
            return -result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(000345+" "+reverse(-(000345)));
    }
}
