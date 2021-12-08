package tree.allNodesDistancekInBinaryTree863;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Medium
 * @author lin  2021/12/8 15:16
 */
public class AllNodesDistancekInBinaryTree {

    public static void main(String[] args) {
        System.out.println(new AllNodesDistancekInBinaryTree().distanceK2(TreeNode.int2TreeNode(1,2,3,4,5,6), new TreeNode(1), 2));
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();
        /**
         * 一开始思路：
         * 以自己为根的左右子树比较好判断，关键点在于如何判断到其他树的距离？
         */

        return res;
    }

    /**
     * 题解
     */
    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点
        findParents(root);

        // 从 target 出发 DFS，寻找所有深度为 k 的结点
        findAns(target, null, 0, k);

        return ans;
    }

    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }


}
