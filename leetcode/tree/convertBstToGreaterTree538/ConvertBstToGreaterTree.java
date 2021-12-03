package tree.convertBstToGreaterTree538;

import tree.TreeNode;

/**
 * @author lin  2021/12/3 14:48
 */
public class ConvertBstToGreaterTree {


    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    private void traverse(TreeNode root){
        if (root == null) return;

        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
