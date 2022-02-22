package linkedlist.rotateList61;


import linkedlist.ListNode;

/**
 * Medium
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class RotateList {


    public static void main(String[] args) {

        ListNode head = ListNode.mkListNode(5);
        ListNode head1 = ListNode.mkListNode(0,1,2);
        ListNode head2 = ListNode.mkListNode(1,2);
        System.out.println(new RotateList().rotateRight(head, 2));
        System.out.println(new RotateList().rotateRight(head1, 4));
        System.out.println(new RotateList().rotateRight(head2, 1));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //1. 基础情况：如果k % head.length   == 0, 链表保持不变，return head即可
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        int times = k % len;
        if (times == 0) return head;
        //2. 旋转本质上考虑倒数第（k % head.length）个节点，断开前节点，重新拼接
        ListNode fast = head, slow = head, last = null;
        for (int i = 0; i < times; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;  // fast 为最后的节点，重新连回到原来的head即可
        }
        dummy.next = slow.next; // slow.next为新的头节点
        slow.next = null; // 断开原节点
        fast.next = head;

        return dummy.next;
    }
}
