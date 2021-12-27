package linkedlist.deleteNodeInALinkedList237;

import linkedlist.ListNode;

/**
 * Easy
 * @author lin  2021/12/27 19:32
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        /**
         * 一开始思路：这是简单题，拿不到头结点的情况下如何删除自己？
         * node = node.next?
         *
         * 题解思路：删除只能删除自己下一个节点，即node.next = node.next.next;
         * 问题：下个节点怎么办？自己变成下一个节点：node.val = node.next.val;
         */
        node.val = node.next.val;
        node.next = node.next.next;

    }

}
