package linkedlist.palindromeLinkedList234;

import linkedlist.ListNode;

/**
 * Easy
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        System.out.println(new PalindromeLinkedList().isPalindrome(ListNode.mkListNode(10)));
        System.out.println(new PalindromeLinkedList().isPalindrome2(ListNode.mkListNode(1,2)));
        System.out.println(new PalindromeLinkedList().isPalindrome(ListNode.mkListNode(2,1)));
    }

    /**
     * 题目是easy,回文链表：可以考虑stack,压栈，出栈时与原链表比较，一致即为回文
     * 这里写另外一种 ： 先 mid，在反转，判断即可；作为多练习
     */
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode reversed = reverse(next);
        while (reversed != null){
            if (reversed.val != head.val){
                return false;
            }
            reversed = reversed.next;
            head = head.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) { //返回第二个节点会导致直接为反转后的链表为null的问题（会直接返回true），这里返回第一个节点
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 1->(2<-3<-4<-5)
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
         ListNode last = reverse(head.next);
         head.next.next = head;
         head.next = null;
         return last;
    }


    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
