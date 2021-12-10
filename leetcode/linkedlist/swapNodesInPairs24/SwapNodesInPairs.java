package linkedlist.swapNodesInPairs24;

import linkedlist.ListNode;

/**
 * Medium
 * @author lin  2021/12/10 15:03
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {


        /**
         * 不难，纯指针操作，需要画图想清楚需要几个指针，怎么切换：
         */
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode tmp = dummyHead;
        while (tmp.next != null && tmp.next.next != null){
            ListNode p1 = tmp.next;
            ListNode p2 = tmp.next.next;

            tmp.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            tmp = p1;
        }
        return dummyHead.next;
    }

    /**
     * 链表问题都可以递归操作：
     * 1->2->3->4->5->6  思考：交换从3开始：即 1->2->(4->3->6->5)
     * 只需要考虑把1->2交换过来即可：
     * head.next = swapPairsR(head.next.next)
     * head.next.next = head;
     * 但这么写 next指针明显错乱了，所以需要保存head.next
     */

    public ListNode swapPairsR(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;

        head.next = swapPairsR(next.next);

        next.next = head;
        return next;
    }

}
