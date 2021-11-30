package tree.kthSmallestElementInABst230;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lin  2021/11/30 14:12
 */
public class KthSmallestElementInABst {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        System.out.println(new KthSmallestElementInABst().kthSmallestR(node, 2));

    }

    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0){
                return root.val;
            }
            root = root.right;
        }
        return -1;

    }

    //递归解法
    public int kthSmallestR(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    int rank = 0;
    int res = 0;
    void traverse(TreeNode root, int k){

        if (root == null) return;
        traverse(root.left, k);

        /*中序遍历代码位置*/
        rank++;
        if (k == rank){
            res = root.val;
            return;
        }
        /**********模板代码***********/
        traverse(root.right, k);

    }

}
