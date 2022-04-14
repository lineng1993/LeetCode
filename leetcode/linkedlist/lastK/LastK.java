package linkedlist.lastK;

import linkedlist.ListNode;

/**
 * Easy 牛客网
 * @author lin  2022/4/14 21:23
 */
public class LastK {


    public static void main(String[] args) {

        ListNode node = ListNode.mkListNode(0,2,3,4,5);
        System.out.println(new LastK().FindKthToTail(node, 6));
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead == null) return null;
        ListNode fast = pHead;
        while (fast != null && k > 0){
            fast = fast.next;
            k--;
        }
        if (k > 0) return null;
        ListNode res = pHead;
        while(fast != null){
            res = res.next;
            fast = fast.next;
        }
        return res;
    }
}
