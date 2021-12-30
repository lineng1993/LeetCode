package tree.binaryTreePostTraversal145;

import tree.TreeNode;

import java.util.*;

/**
 * Easy
 * @author lin  2021/12/30 15:02
 */
public class BinaryTreePostTraversal {


    public static void main(String[] args) {
        BinaryTreePostTraversal postTraversal = new BinaryTreePostTraversal();
        TreeNode root = TreeNode.int2TreeNode(1,2,3,4,5,6,7);
        System.out.println(postTraversal.postorderTraversal(root));
        System.out.println(postTraversal.postorderTraversalNoR(root));
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> nodes){
        if(root == null) return;
        traverse(root.left, nodes);
        traverse(root.right, nodes);
        nodes.add(root.val);
    }

    /**
     * 前序：中左右
     * 后序：左右中
     * 如果 前序遍历时按照 右左中来遍历，那么把结果反转就是后序遍历了
     */
    public List<Integer> postorderTraversalNoR(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            //注意这里先加入左节点，因为我们的遍历顺序需要时 中右左
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

}
