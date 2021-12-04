package tree.pathSum437;

import tree.TreeNode;

/**
 * Medium
 * https://leetcode-cn.com/problems/path-sum-iii/
 *
 * @author lin  2021/12/4 23:21
 */
public class PathSum {


    public int pathSum(TreeNode root, int sum){


        /* 思路：如何穷举所有可能性？如何计算全部子路径？
         * 递归的思想：只要在遍历的路上发现符合条件即+1，不需要考虑终止条件；
         */
        int res = dfs(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    private int dfs(TreeNode node, int num){
        int res = 0;

        if (node == null) return 0;
        int val = node.val;
        if (val == num){
            res ++;
        }
        res += dfs(node.left, num - val);
        res += dfs(node.right, num - val);
        return res;
    }


}
