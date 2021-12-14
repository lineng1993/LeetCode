package linkedlist.removeDuplicatesFromSortedList84;

import linkedlist.ListNode;

/**
 * Medium
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字
 * @author lin  2021/12/14 17:18
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        System.out.println(new RemoveDuplicatesFromSortedList().deleteDuplicates(ListNode.mkListNode(1,1,1,2)));
    }

    public ListNode deleteDuplicates(ListNode head){

        /*
         * 84题的升级版，重复的全部要删除，因此头节点也可能被删
         * 一开始思路：dummy节点，条件：cur.next = cur.next.next.val,因此条件为 while(cur.next.next != null)
         * 循环体示例：-1(dummy)->1->1->1->2
         */
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        /*
         * cur.next自然也不能为null,一开始没考虑到
         */
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                /*
                 * 不能按照84题一遍遍循环了，需要一次性全部删掉
                 */
                while (cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
