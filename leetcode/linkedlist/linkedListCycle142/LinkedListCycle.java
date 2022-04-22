package linkedlist.linkedListCycle142;

import linkedlist.ListNode;

/**
 * Medium
 * @author lin  2022/4/22 20:45
 */
public class LinkedListCycle {


    public ListNode detectCycle(ListNode head) {
        //这种情况肯定无环了
        if(head == null || head.next == null || head.next.next == null) return null;

        /**
         * 1：有环时快慢指针相遇
         * 2. 相遇后，慢指针保持位置不变，快指针从头开始，此时每次走一步，与慢指针再次相遇时
         */

        ListNode fast = head;
        ListNode slow = head;
        while (fast != slow){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //相遇了
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
