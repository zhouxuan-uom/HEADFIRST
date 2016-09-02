package kris;

/**
 * Created by zhouxuan on 16/7/5.
 */
public class CycleLink {
    public boolean hasCycle(ListNodeKris head) {
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
        ListNodeKris l1 = new ListNodeKris(1);
        ListNodeKris l2 = new ListNodeKris(2);
        ListNodeKris l3 = new ListNodeKris(1);
        ListNodeKris l4 = new ListNodeKris(2);
        ListNodeKris l5 = new ListNodeKris(1);
        ListNodeKris l6 = new ListNodeKris(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        System.out.println((l1));
    }
}
