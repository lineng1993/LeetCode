package array.tree.convertSortedListToBinarySearchTree109;


import array.tree.TreeNode;
import linkedlist.ListNode;

/**
 * Medium
 */
public class ConvertSortedListToBinarySearchTree {


    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        /*找到中间节点,在递归处理*/
        ListNode pre = head; // 需要记录 mid 的前一个节点
        ListNode mid = pre.next;
        ListNode fast = mid.next;
        while (fast != null && fast.next != null){
            pre = pre.next;
            mid = pre.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }


}
