package interview.algorithm.questions;

import interview.algorithm.ans.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Created by zhouxuan on 16/9/2.
 */
public interface AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2);
}
