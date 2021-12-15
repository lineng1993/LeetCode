package linkedlist.oddEvenLinkedList328;

import linkedlist.ListNode;

/**
 * Medium
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {

        System.out.println(new OddEvenLinkedList().oddEvenList(ListNode.mkListNode(1,2,3,4,5)));
    }

    public ListNode oddEvenList(ListNode head) {

        /** 一开始思路：这题跟86几乎完全一样
         * 都是head指针移动即可，odd和even分别指向不同的next即可，然后在拼接，需要注意的是最后的 evenNode.next要置为null，否则就是环了
         */
        ListNode oddDummy = new ListNode(-1);
        ListNode oddNode = oddDummy;
        ListNode evenDummy = new ListNode(-1);
        ListNode evenNode = evenDummy;

        int count = 1;
        while (head != null){

            if ((count & 1) == 0){
                evenNode.next = head;
                evenNode = evenNode.next;
            }else {
                oddNode.next = head;
                oddNode = oddNode.next;
            }
            head = head.next;
            count++;
        }
        evenNode.next = null;
        oddNode.next = evenDummy.next;
        return oddDummy.next;
    }
}
