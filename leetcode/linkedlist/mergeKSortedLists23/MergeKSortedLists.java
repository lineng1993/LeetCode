package linkedlist.mergeKSortedLists23;

import linkedlist.ListNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hard
 * @author lin  2022/4/11 19:50
 */
public class MergeKSortedLists {


    public static void main(String[] args) {

        ListNode node = ListNode.mkListNode(1,2,3,4,5);
        ListNode node2 = ListNode.mkListNode(4,5,6,7,8);
        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = node;
        listNodes[1] = node2;
        System.out.println(new MergeKSortedLists().mergeKLists(listNodes));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 构建最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        // 添加全部头结点
        queue.addAll(Arrays.asList(lists));

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            // 放入最小堆，每次都取最小值
            if (node.next != null){
                queue.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;

    }
}
