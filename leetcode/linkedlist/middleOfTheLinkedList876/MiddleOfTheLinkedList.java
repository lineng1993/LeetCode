package linkedlist.middleOfTheLinkedList876;

import linkedlist.ListNode;

/**
 * Easy
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @author lin  2021/12/13 16:22
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        System.out.println(new MiddleOfTheLinkedList().middleNode(ListNode.mkListNode(1,2,3,4,5,6)).val);
    }

    public ListNode middleNode(ListNode head) {
        /**
         *  思路明显是快慢指针：如何定义快慢？快的速度是慢的2倍，因此快指针为null时，慢指针刚好在中间。
         */
        ListNode slow = head;
        ListNode fast = head;
        //注意fast也可能为null
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
