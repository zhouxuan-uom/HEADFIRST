package interview.algorithm.ans;

import interview.algorithm.RotateList;
import kris.ListNode;

/**
 * Created by zhouxuan on 16/9/1.
 */
public class RotateListAnswer implements RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode root = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        ListNode head1 = head.next;
        head.next = null;
        head = head1;
        while (head1.next != null) {
            head1 = head1.next;
        }
        head1.next = root;
        return head;
    }
}
