package tree.flattenBinaryTreeToLinkedList114;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin  2021/12/2 16:56
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

        new FlattenBinaryTreeToLinkedList().flatten2(TreeNode.int2TreeNode(1,2,3,4,5,6,7));
    }

    /**
     * 前序遍历
     * @param root
     */
    public void flatten(TreeNode root){

        List<TreeNode> treeNodes = new ArrayList<>();
        preOrder(root, treeNodes);
        int size = treeNodes.size();
        TreeNode cur = treeNodes.get(0);
        for (int i = 1; i <= size - 1; i++) {
            TreeNode node = treeNodes.get(i);
            cur.left = null;
            cur.right = node;
            cur = node;
        }
        System.out.println(root);
    }

    private void preOrder(TreeNode root, List<TreeNode> treeNodeList){

        if (root == null) return;
        treeNodeList.add(root);
        preOrder(root.left, treeNodeList);
        preOrder(root.right, treeNodeList);
    }

    private void preOrderNoR(TreeNode root, List<TreeNode> treeNodeList){
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            treeNodeList.add(node);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }
    /**
     * 后序遍历
     * @param root
     */
    public void flatten2(TreeNode root){
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;


        TreeNode p = root;
        while (p.right != null) {
            p = p.right; //遍历到末尾把原来的右节点挂上去
        }
        p.right = right;
        System.out.println(root);
    }

}
