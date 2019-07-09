package interview.algorithm.hard.answers;

import interview.algorithm.hard.questions.ShortestPalindrome;

/**
 * Created by zhouxuan on 2018/8/20
 *
 * @Author: zhouxuan
 * @Date: 2018/8/20
 */

public class ShortestPalindromeAns implements ShortestPalindrome {
    @Override
    public String shortestPalindrome(String s) {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            String merge = s1 + s;
            s2 = s2 + s.charAt(s.length() - 1 - i);
            char right = s.charAt(s.length() - 1 - i);
            char left = merge.charAt(i);
            if (left != right) {
                s1 = s2;
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        String s = "223322123";
        System.out.println(new ShortestPalindromeAns().shortestPalindrome(s));
    }
}
