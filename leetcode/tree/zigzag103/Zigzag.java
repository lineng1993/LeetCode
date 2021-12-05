package tree.zigzag103;


import tree.TreeNode;

import java.util.*;


/**
 * Medium
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Zigzag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        /* 二叉树的层序遍历，区别是要区分奇偶层，入队顺序会不一样？
         */
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return res;
        deque.offer(root);
        int num = 1;
        while(!deque.isEmpty())
        {
            int n = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.poll();
                level.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            if ((n & num) != 1){
                //这里保留了中序遍历的代码，只是把列表反向了，就不需要多余考虑入队顺序的问题了
                Collections.reverse(level);
            }
            res.add(level);
            num++;
        }
        return res;
    }


}
