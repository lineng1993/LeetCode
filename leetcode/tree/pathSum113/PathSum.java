package tree.pathSum113;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Medium
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * @author lin  2021/12/4 23:23
 */
public class PathSum {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    /**
     * 终止条件为左右子节点为空，如果此时该节点符合要求，数组可以加入，什么时候新建数组?
     * 257题直接使用了字符串path，这里使用全局链表，遍历完时需要移除当前及诶单
     *
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode node, int num){

        if (node == null) return;
        path.push(node.val);
        //终止条件：
        if (node.left == null || node.right == null){
            // 符合条件
            if (num - node.val == 0){
                res.add(new LinkedList<>(path));
                //不能return，否则无法移除当前节点
            }
        }
        dfs(node.left, num - node.val);
        dfs(node.right, num - node.val);
        //不符合条件时移除当前节点
        path.pollLast();
    }

}
