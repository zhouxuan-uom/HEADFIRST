package interview.algorithm.accepted;

import interview.algorithm.questions.AddTwoNumbers;
import interview.algorithm.ans.ListNode;

/**
 * Created by zhouxuan on 16/9/2.
 */
public class AddTwoNumbersAnswer implements AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int p = 0;
        int add = l1.val + l2.val;
        if (add >= 10) {
            add -= 10;
            p++;
        }
        ListNode result = new ListNode(add);
        ListNode head = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            add = l1.val + l2.val + p;
            p = 0;
            if (add >= 10) {
                add -= 10;
                p++;
            }
            head.next = new ListNode(add);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null || l2 != null || p != 0) {
            if (l1 != null) {
                int r = l1.val + p;
                head.next = new ListNode(r%10);
                p = r/10;
                head = head.next;
                l1 = l1.next;
            } else if (l2 != null) {
                int r = l2.val + p;
                head.next = new ListNode(r%10);
                p = r/10;
                head = head.next;
                l2 = l2.next;
            } else if (p != 0) {
                head.next = new ListNode(p);
                p = 0;
                head = head.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbersAnswer();
        ListNode l1 = new ListNode(9);
        ListNode l = new ListNode(9);
        l1.next = l;
        ListNode l2 = new ListNode(1);
        System.out.println(addTwoNumbers.addTwoNumbers(l1, l2).val);
    }
}
