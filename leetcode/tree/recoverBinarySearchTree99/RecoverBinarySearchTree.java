package tree.recoverBinarySearchTree99;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Medium
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * @author lin  2022/1/25 下午3:04
 */
public class RecoverBinarySearchTree {

    /**
     * 见到二叉搜索树第一反应一定先想一下中序遍历
     * @param root
     */
    public void recoverTree(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null, x = null, y = null;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            //找到错位元素
            if (pre != null && root.val < pre.val){
                y = root;
                if (x == null){
                    x = pre;
                }
            }
            pre = node;
            root = node.right;
        }
        swap(x, y);

    }

    private void swap(TreeNode x, TreeNode y){
        int tmp = x.val;
        x.val = y.val;
        x.val = tmp;
    }

    public void recoverTree2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null, x = null, y = null;
        while(!stack.isEmpty() || root != null){

            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            //找到错误节点
            if(pre != null && node.val < pre.val){
                y = node;
                if(x == null){
                    x = pre;
                }
            }
            pre = node;
            root = node.right;
        }
        swap(x, y);

    }

}
