package linkedlist.intersectionOfTwoLinkedLists160;

import linkedlist.ListNode;

/**
 * Easy
 * @author lin  2022/4/15 11:06
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;

        ListNode p1 = headA, p2 = headB;
        while (p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
