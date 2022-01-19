package linkedlist.reorderList143;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * L0 → L1 → … → Ln - 1 → Ln 转换成
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * @author lin  2021/12/13 16:01
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        /**
         * 一开始思路：双指针，tail从后往前，head从前往后，head == tail时返回，head,tail交替累加
         * 问题：指针往前移不动
         */

        /**
         * 线性表，转换成数组，直接用数组下标，解决了一开始的思路指针移不动的问题
         * 链表问题应该多考虑转换成其他数据结构，简单粗暴，但往往不是最优解，可以作为第一版思路
         */
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;

        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;//断开原来的链表

    }

    /**
     * 官方题解
     * @param head LinkedList
     */
    public void reorderList2(ListNode head){
        // 1. 找到链表中点 876题
        ListNode mid = middleNode(head);
        // 2. 反转链表,需要注意这里要提前保留指针，因为后边断开了
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        // 3. 合并2个链表
        merge(head, l2);
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private void merge(ListNode l1, ListNode l2){
        ListNode l1Tmp, l2Tmp;
        while (l1 != null && l2 != null){
            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1;
            l2 = l2Tmp;
        }
    }
}
