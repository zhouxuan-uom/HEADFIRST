package interview.algorithm;

import interview.algorithm.ans.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * Created by zhouxuan on 16/9/1.
 */
public interface RotateList {
    public ListNode rotateRight(ListNode head, int k);
}
