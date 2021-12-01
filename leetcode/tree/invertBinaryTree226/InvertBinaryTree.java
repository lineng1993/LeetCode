package tree.invertBinaryTree226;

import tree.TreeNode;

/**
 * @author lin  2021/12/1 09:36
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;

        /**
         * 前续遍历
         * TreeNode tmp = root.left;
         * root.left = root.right;
         * root.right = tmp;
         */

        invertTree(root.left);
        invertTree(root.right);

        //后续遍历
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

}
