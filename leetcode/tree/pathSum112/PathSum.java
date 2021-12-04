package tree.pathSum112;

import tree.TreeNode;

/**
 * Easy
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
