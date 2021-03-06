package tree.binaryTreeInorderTraversal94;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lin  2021/11/29 19:48
 */
public class BinaryTreeInorderTraversal {


    public static void main(String[] args) {

        TreeNode root = TreeNode.int2TreeNode(1,2,3,4,5,6,7,8);
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversalNoR(root));
    }

    /**
     * 常规版，正常递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        innerInorderTraversal(res, root);
        return res;
    }

    public void innerInorderTraversal(List<Integer> res, TreeNode root){
        if (root == null) return;
        innerInorderTraversal(res, root.left);
        res.add(root.val);
        innerInorderTraversal(res, root.right);
    }

    /**
     * 非递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalNoR(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root); //将访问的节点放进栈
                root = root.left;  //左
            }
            //中
            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;  //右
        }
        return res;
    }


}
