package linkedlist.addTwoNumbers2;

import linkedlist.ListNode;

/**
 * Medium
 * @author lin  2021/12/10 14:46
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        /**
         * 思路：题做过好几次了，关键点在于其中之一的链表为空了
         * 代码风格要好
         */
        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = l1,p2 = l2, cur = dummyHead;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int m = p1 == null ? 0 : p1.val;
            int n = p2 == null ? 0 : p2.val;
            int sum = m + n + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            cur = cur.next;
        }
        if (carry > 0){
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
