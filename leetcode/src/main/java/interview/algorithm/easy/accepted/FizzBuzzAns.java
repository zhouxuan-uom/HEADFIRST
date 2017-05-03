package interview.algorithm.easy.accepted;

import interview.algorithm.easy.questions.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * Example:
 * n = 15,
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * Created by zhouxuan on 2016/12/8.
 */
public class FizzBuzzAns implements FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) {
                str = str + "Fizz";
            }
            if (i % 5 == 0) {
                str = str + "Buzz";
            }
            if (str.equals("")) {
                str = str + i;
            }
            result.add(str);
        }
        return result;
    }
}
