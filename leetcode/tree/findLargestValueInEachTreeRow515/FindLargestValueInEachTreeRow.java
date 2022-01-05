package tree.findLargestValueInEachTreeRow515;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Medium
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class FindLargestValueInEachTreeRow {


    public List<Integer> largestValues(TreeNode root) {

        /**
         * 典型的层序遍历，直接写代码就好
         */

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                max = Math.max(max, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
