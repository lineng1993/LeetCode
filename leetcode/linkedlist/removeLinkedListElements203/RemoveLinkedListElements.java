package linkedlist.removeLinkedListElements203;

import linkedlist.ListNode;

/**
 * Easy
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @author lin  2021/12/16 17:05
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {

        System.out.println(new RemoveLinkedListElements().removeElements(ListNode.mkListNode(1,2,2,3,4,5,2), 2));
    }


    public ListNode removeElements(ListNode head, int val) {
        //一开始思路：dummy节点，正常删除即可

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur != null && cur.next != null){
            while (cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }


//        题解
//        while (cur.next != null){
//           if(cur.next.val == val){
//               cur.next = cur.next.next;
//           }else {
//               cur = cur.next;
//           }
//        }
        return dummy.next;
    }

}
