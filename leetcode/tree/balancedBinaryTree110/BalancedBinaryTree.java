package tree.balancedBinaryTree110;

import tree.TreeNode;

/**
 * Easy
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 * 1. 自底向上
 * 2. 自顶向下
 * @author lin  2021/12/7 11:30
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root){

        //思路：后序遍历，先拿到左右两颗子树高度，对比差值即可。
        return maxHeight(root) >= 0;
    }

    private int maxHeight(TreeNode node) {

        if (node == null) return 0;

        int left = maxHeight(node.left);
        int right = maxHeight(node.right);

        //关键代码：这里比较巧妙，如何返回,避免计算，直接返回了-1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }


    //常规思路,计算节点高度，存在大量计算，不如上面的方法
    public int height(TreeNode root){
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    //调用：当前高度差<=1,左右子树分别是平衡的
    public boolean isBalanced2(TreeNode root){
        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }

}
