package linkedlist.sortList148;

import linkedlist.ListNode;

/**
 * Medium
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶需求：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * @author lin  2021/12/14 17:38
 */
public class SortList {

    public ListNode sortList(ListNode head) {

        /*
         * 没有思路
         */

        /**
         * 题解思路：
         * 题目的进阶问题要求达到 O(n \log n)O(nlogn) 的时间复杂度和 O(1)O(1) 的空间复杂度，时间复杂度是 O(n \log n)O(nlogn) 的排序算法包括归并排序、堆排序和快速排序
         * 其中最适合链表的排序算法是归并排序。
         * 自顶向下归并排序：
         * 1：找到链表的中点，以中点为分界，将链表拆分成两个子链表
         * 2：对两个子链表分别排序。
         * 3：将两个排序后的子链表合并，得到完整的排序后的链表（21题）
         */

        return sortList(head, null);

    }

    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null) return null;
        //递归终止
        if (head.next == tail){
            head.next = null;
            return head;
        }

        ListNode mid = middleNode(head);

        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(mid, tail);
        return merge(l1, l2);
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy, p1 = l1, p2 = l2;
        while (p1 != null && p2 != null){
            if (p1.val <= p2.val){
                cur.next = p1;
                p1 = p1.next;
            }else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = (p1 == null) ? p2 : p1;
        return dummy.next;
    }
}
