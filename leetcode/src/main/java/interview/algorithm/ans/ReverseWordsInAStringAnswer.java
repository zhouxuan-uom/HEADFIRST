package interview.algorithm.ans;

import interview.algorithm.questions.ReverseWordsInAString;

/**
 * Created by zhouxuan on 16/8/24.
 */
public class ReverseWordsInAStringAnswer implements ReverseWordsInAString {
    public String reverseWords(String s) {
        String r = "";
        s = s.trim();
        int end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                r += s.substring(i + 1, end);
                r += " ";
                end = i;
                continue;
            }
        }
        r += s.substring(0, end);
        return r;
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAStringAnswer();
        String s = "main void test";
        System.out.println(reverseWordsInAString.reverseWords(s));
    }
}
