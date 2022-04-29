package tree.mergeTwoBinaryTrees617;

import tree.TreeNode;

/**
 * Easy
 */
public class MergeTwoBinaryTrees {


    public static void main(String[] args) {

        TreeNode root1 = TreeNode.int2TreeNode(1,2,3,4,5);
        TreeNode root2 = TreeNode.int2TreeNode(1,2,3,4,5,6,7);
        System.out.println(new MergeTwoBinaryTrees().mergeTrees2(root1, root2));

    }

    /**
     * 简单题，写的比较顺利，本题前中后序都是可以得
     */

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;


        root1.left = mergeTrees(root1.left, root2.left);
        root1.val += root2.val;
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;


        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        root1.val += root2.val;
        return root1;
    }

}
