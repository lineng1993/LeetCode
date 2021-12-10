package linkedlist.mergeTwoSortedLists21;

import linkedlist.ListNode;

/**
 * Easy
 * @author lin  2021/12/10 14:57
 */
public class MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, cur = dummy;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                cur.next = new ListNode(p1.val);
                p1 = p1.next;
            }else{
                cur.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = (p1 == null) ? p2 : p1;
        return dummy.next;
    }

}
