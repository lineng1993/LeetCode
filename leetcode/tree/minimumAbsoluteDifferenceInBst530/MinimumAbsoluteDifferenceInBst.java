package tree.minimumAbsoluteDifferenceInBst530;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Easy
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class MinimumAbsoluteDifferenceInBst {



    public int getMinimumDifference(TreeNode root) {

        /**
         * 思路：Easy题，BST特性是有序：结合二叉树，中序遍历即有序数组，在计算数组得差值即可
         */

        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        while (root != null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            //
            arr.add(node.val);
            root = node.right;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            min = Math.min(min, arr.get(i + 1) - arr.get(i));
        }
        return min;
    }

    public int getMinimumDifference2(TreeNode root) {

        /**
         * 优化下，在过程中直接取值
         */

        Deque<TreeNode> stack = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            //
            if (pre != null){
                min = Math.min(min, node.val - pre.val);
            }
            pre = node;
            root = node.right;
        }

        return min;
    }

}
