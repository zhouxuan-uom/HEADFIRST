package kris;

/**
 * Created by zhouxuan on 16/7/5.
 */
public class CycleLink {
    public boolean hasCycle(ListNode head) {
        while (true) {
            if (head.next == null) {
                return false;
            }
            if (head == head.next) {
                return true;
            }
            head = head.next;
            if (head.next == null) {
                return false;
            }
            head.next = head.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        System.out.println((l1));
    }
}
