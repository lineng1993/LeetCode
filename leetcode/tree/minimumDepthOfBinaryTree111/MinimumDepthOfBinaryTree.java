package tree.minimumDepthOfBinaryTree111;

import tree.TreeNode;

/**
 * Easy
 * @author lin  2021/12/30 20:03
 */
public class MinimumDepthOfBinaryTree {


    public int minDepth(TreeNode root) {

        return depth(root);

    }
    private int depth(TreeNode root){


        /**
         * 需要注意的误区：
         * int leftDepth = getDepth(node->left);
         * int rightDepth = getDepth(node->right);
         * int result = 1 + min(leftDepth, rightDepth);
         * return result;
         */

        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);


        if (root.left == null && root.right != null){
            return 1 + rightDepth;
        }

        if (root.left != null && root.right == null){
            return 1 + leftDepth;
        }
        return 1 + Math.min(leftDepth, rightDepth);

    }

    /**
     * 进阶精简代码
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null){
            return 1 + minDepth2(root.right);
        }
        if (root.left != null && root.right == null){
            return 1 + minDepth2(root.left);
        }
        return 1 + Math.min(minDepth2(root.left), minDepth2(root.right));
    }




}
