package linkedlist.reverseLinkedList206;

import linkedlist.ListNode;

/**
 * @author lin  2021/12/10 16:18
 */
public class ReverseLinkedList {


    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseListR(ListNode head) {
        if (head == null) return head;
        ListNode last = reverseListR(head.next);

        head.next.next = head;
        head.next = null;
        return last;
    }
}
