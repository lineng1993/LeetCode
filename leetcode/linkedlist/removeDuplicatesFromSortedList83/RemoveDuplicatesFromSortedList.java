package linkedlist.removeDuplicatesFromSortedList83;

import linkedlist.ListNode;

/**
 * Easy
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * @author lin  2021/12/14 17:07
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        System.out.println(new RemoveDuplicatesFromSortedList().deleteDuplicates(ListNode.mkListNode(1,1,2,2,3,3,4,4,5,5)));
    }

    public ListNode deleteDuplicates(ListNode head){
        if (head == null) return null;

        /**
         * 一开始思路：删除链表：head.next = head.next.next,前提条件 head.next != null
         */
        ListNode cur = head;
//        while (cur != null){
//            while (cur.next != null && cur.val == cur.next.val){
//                cur.next = cur.next.next;
//            }
//            cur = cur.next;
//        }

        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;

    }
}
