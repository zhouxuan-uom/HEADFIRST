package kris;

/**
 * Created by zhouxuan on 16/7/5.
 */
public class MergeList {
    public ListNodeKris mergeTwoLists(ListNodeKris l1, ListNodeKris l2) {
        ListNodeKris l3;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l3 = l1;
            l1 = l1.next;
        } else {
            l3 = l2;
            l2 = l2.next;
        }
        l3.next = mergeTwoLists(l1, l2);
        return l3;
    }
}
