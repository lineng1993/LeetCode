package tree.pathSum112;

import tree.TreeNode;

/**
 * Easy
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * @author lin  2021/12/4 22:48
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum){
        //base
        if (root == null) return false;
        //只有一个节点，因为后面递归遇到null时返回了false
        if (root.left == null && root.right == null){
            return sum - root.val == 0;
        }
        //递归，左右节点有符合对应值的即可
        return hasPathSum(root.left, sum - root.val)||
                hasPathSum(root.right, sum - root.val);
    }
}
