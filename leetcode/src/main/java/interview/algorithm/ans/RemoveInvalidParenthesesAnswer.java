package interview.algorithm.ans;

import interview.algorithm.RemoveInvalidParentheses;

import java.util.List;
import java.util.Stack;

/**
 * Created by zhouxuan on 16/8/31.
 */
public class RemoveInvalidParenthesesAnswer implements RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Stack stack = new Stack();
        int leftErr = 0;
        int rightErr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.size() != 0) {
                    stack.pop();
                } else {
                    leftErr++;
                }
            }
        }
        rightErr += stack.size();
        return null;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParenthesesAnswer();
        removeInvalidParentheses.removeInvalidParentheses("()))()()((((");
    }
}
