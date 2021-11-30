package tree.validateBinarySearchTree98;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lin  2021/11/30 11:28
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean helper(TreeNode root, int max, int min){
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, root.val,min) &&
                helper(root.right, max, root.val);
    }

    /**
     * 中序遍历判断是否有序
     * @param root TreeNode
     * @return isBST
     */
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        int inOrder = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (node.val <= inOrder){
                return false;
            }
            inOrder = node.val;
            root = node.right;
        }
        return true;
    }
}
