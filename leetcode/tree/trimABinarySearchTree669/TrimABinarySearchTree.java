package tree.trimABinarySearchTree669;

import tree.TreeNode;

/**
 * Medium
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 */
public class TrimABinarySearchTree {


    public TreeNode trimBST(TreeNode root, int low, int high) {


        /**
         * 递归三部曲：
         * 1. 确定递归函数的参数以及返回值
         * 为什么需要返回值？
         * 因为是要遍历整棵树，做修改，其实不需要返回值也可以，我们也可以完成修剪（其实就是从二叉树中移除节点）的操作。
         * 但是有返回值，更方便，可以通过递归函数的返回值来移除节点。
         * 2. 确定终止条件
         * 修剪的操作并不是在终止条件上进行的，所以就是遇到空节点返回就可以了。
         * 3. 确定单层递归的逻辑（核心代码）
         * 如果root（当前节点）的元素小于low的数值，那么应该递归右子树，并返回右子树符合条件的头结点。
         * 如果root(当前节点)的元素大于high的，那么应该递归左子树，并返回左子树符合条件的头结点。
         */

        if (root == null) return null;
        if (root.val < low){
            return trimBST(root.right, low, high);
        }
        if (root.val > high){
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    public TreeNode trimBST2(TreeNode root, int low, int high){
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            //因为是二叉搜索树,节点.left < 节点 < 节点.right
            //节点数字比low小,就把左节点全部裁掉.
            root = root.right;
            //裁掉之后,继续看右节点的剪裁情况.剪裁后重新赋值给root.
            root = trimBST(root, low, high);
        } else if (root.val > high) {
            //如果数字比high大,就把右节点全部裁掉.
            root = root.left;
            //裁掉之后,继续看左节点的剪裁情况
            root = trimBST(root, low, high);
        } else {
            //如果数字在区间内,就去裁剪左右子节点.
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }


}
