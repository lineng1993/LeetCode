package tree.maximumDepth104;

import tree.TreeNode;

/**
 * Easy
 * DFS
 * @author lin  2021/12/6 19:07
 */
public class MaximumDepth {

    public int maxDepth(TreeNode root){

        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
