package linkedlist.mergeKSortedLists23;

import linkedlist.ListNode;

import java.util.*;

/**
 * Hard
 * @author lin  2022/4/11 19:50
 */
public class MergeKSortedLists {

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
