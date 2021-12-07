package tree.binaryTreeRightSideView199;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Medium
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @author lin  2021/12/7 17:42
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {


        System.out.println(new BinaryTreeRightSideView().rightSideView(TreeNode.int2TreeNode(1,2,3,4,5,6,7)));
        System.out.println(new BinaryTreeRightSideView().rightSideView2(TreeNode.int2TreeNode(1,2,3,4,5,6,7)));

    }

    public List<Integer> rightSideView(TreeNode root){

        /* 一开始思路：
         * 遍历方式：前中后选哪种 ？ 可以选层序遍历，
         * 什么时候能加入到数组？确认最右边节点
         * 如何确定：levelSize，queue从右往左加
         */
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (i == levelSize - 1){
                    res.add(node.val);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    public List<Integer> rightSideView2(TreeNode root){
        dfs(root, 0);
        return res;
    }

    /**
     * DFS思路：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
     * 如何分层：dfs的每次调用其实就是分层了，那么何时加入结果数组：level == res.size(),每层有且只有一个元素
     */

    List<Integer> res = new ArrayList<>();
    private void dfs(TreeNode root, int depth){
        if (root == null) return;
        if (depth == res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

}
