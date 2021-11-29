package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lin  2021/11/29 19:49
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 按层序遍历生成二叉树
     * @param args
     * @return
     */
    public static TreeNode int2TreeNode(int ...args){

        int n = args.length;
        assert n > 0;
        TreeNode root = new TreeNode(args[0]);
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        for (int i = 1; i < n;) {
            TreeNode node = treeNodes.poll();
            node.left = new TreeNode(args[i]);
            i++;
            if (i < n){
                node.right = new TreeNode(args[i]);
            }
            i++;
            treeNodes.offer(node.left);
            treeNodes.add(node.right);
        }
        return root;
    }

    /**
     * level order
     * @return
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            sb.append(node.val).append("->");
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        sb.append("NULL");
        return sb.toString();
    }
}
