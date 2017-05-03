package interview.algorithm.ans;

import interview.algorithm.questions.BasicCalculator;

import java.util.Stack;

/**
 * Created by zhouxuan on 2016/12/1.
 */
public class BasicCalculatorAnswer implements BasicCalculator {
    private static String[] symbols = {"+", "-", "*", "/", "(", ")"};
    private static String[] mult = {"*", "/"};

    public int calculate(String s) {
        Stack<String> stack = new Stack();
        Stack<String> tempStack = new Stack<String>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (arrayHas(symbols, ch)) {
                if (temp != "") {
                    stack.push(temp);
                }
                stack.push(ch.toString());
                temp = "";
            } else {
                temp += ch;
            }
            if (ch == ')') {
                for (int j = 0; j < i; j++) {
                    String chj = stack.pop();
                    if (chj.equals("(")) {
                        break;
                    } else {
                        tempStack.push(chj);
                    }
                }
                int result = calc(tempStack);
                stack.push((result + ""));
                temp = "";
                continue;
            }

        }
        temp = "";
        return calc(stack);
    }

    private int calc(Stack<String> stk) {
//        while (stk.size() != 0) {
//
//        }
        return 0;
    }

    private boolean arrayHas(String[] arr, Character ch) {
        for (String a : arr) {
            if (a.equals(ch.toString())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculatorAnswer();
        basicCalculator.calculate("( 1+2 +3)*4/(5+7)");
    }
}
