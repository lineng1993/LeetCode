package linkedlist.partitionList86;

import linkedlist.ListNode;


/**
 * Medium
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * @author lin  2021/12/13 11:37
 */
public class PartitionList {

    public static void main(String[] args) {

        ListNode head = ListNode.mkListNode(1,4,2,1,3, 5, 6);
        System.out.println(new PartitionList().partition2(head, 4));
    }

    public ListNode partition(ListNode head, int x) {
        /**
         * 一开始思路：
         * 1. 虚拟头节点
         * 2. 使用2个容器分别放ListNode，哪种容器？队列 or 栈,栈顺序是反的，用队列
         * 3. 拼接链表
         */

        /**
         * 评论思路：使用2个虚拟投节点，直接拼接即可
         */

        ListNode smallerDummy = new ListNode(-1);
        ListNode biggerDummy  = new ListNode(-1);

        ListNode smallerNode = smallerDummy;
        ListNode biggerNode  = biggerDummy;

        while(head != null){
            if (head.val < x){
                smallerNode.next = head;
                head = head.next;
                smallerNode = smallerNode.next;
                smallerNode.next = null;
            }else {
                biggerNode.next = head;
                head = head.next;
                biggerNode = biggerNode.next;
                biggerNode.next = null;
            }
        }
        smallerNode.next = biggerDummy.next;
        return smallerDummy.next;
    }

    /**
     * 官方题解
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        //关键代码
        large.next = null;
        small.next = largeHead.next;  //small 前面不需要置null,这里会断开链表
        return smallHead.next;
    }
}
