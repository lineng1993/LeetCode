package tree.binaryTreePreorderTraversal144;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Easy
 * @author lin  2021/12/30 14:41
 */
public class BinaryTreePreorderTraversal {


    public static void main(String[] args) {

        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal(TreeNode.int2TreeNode(1,2,3,4,5,6,7)));
        System.out.println(new BinaryTreePreorderTraversal().preorderTraversalNoR(TreeNode.int2TreeNode(1,2,3,4,5,6,7)));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res){
        if (root == null) return;
        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }

    public List<Integer> preorderTraversalNoR(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null){ //先压右节点
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }

}
