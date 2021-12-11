package linkedlist.linkedListCycle141;


import linkedlist.ListNode;

/**
 * Easy
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        /* 初始思路：典型的快慢指针问题，如果链表有环，快指针会追上慢指针
         * 思路：1.定义快慢指针，可以直接定义 fast = head.next
         * 2. 循环结束条件是什么？快指针追上慢指针：while(slow != fast)
         * 3. 没有环结束条件是什么？fast = null || fast.next = null;
         */
        ListNode fast = head.next, slow = head;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
