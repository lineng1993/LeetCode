package linkedlist;

/**
 * @author lin  2021/12/10 14:47
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }



    public static ListNode mkListNode(int n){
        ListNode node = new ListNode(1);
        ListNode cur = node;
        for (int i = 2; i <= n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return node;
    }

    public static ListNode mkListNode(int ... params){

        ListNode head = new ListNode(params[0]);
        int n = params.length;
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(params[i]);
            cur = cur.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(val);
        ListNode n = next;
        while (n != null){
            sb.append("->").append(n.val);
            n = n.next;
        }
        return sb.toString();
    }
}



