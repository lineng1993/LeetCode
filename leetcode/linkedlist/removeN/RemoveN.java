package linkedlist.removeN;

import linkedlist.ListNode;

/**
 * Medium
 * @author lin  2022/4/15 09:53
 */
public class RemoveN {


    public static void main(String[] args) {

        ListNode node = ListNode.mkListNode(1,2,3,4,5);
        System.out.println(new RemoveN().removeNthFromEnd(node,5));
        node = ListNode.mkListNode(1,2,3,4,5);
        System.out.println(new RemoveN().removeNthFromEnd(node,2));
    }


    public ListNode removeNthFromEnd (ListNode head, int n){
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
