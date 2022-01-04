package tree.diameterOfBinaryTree543;

import tree.TreeNode;

/**
 * Easy
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @author lin  2022/1/4 19:27
 */
public class DiameterOfBinaryTree {


    public static void main(String[] args) {
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree2(TreeNode.int2TreeNode(1,2)));
    }


    public int diameterOfBinaryTree(TreeNode root) {
        //错误解法：可能不经过根节点：参考：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/hot-100-9er-cha-shu-de-zhi-jing-python3-di-gui-ye-/
        //最大长度可能在子树，那么需要记录该值
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left + right;
    }

    private int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    int max = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        maxDepth2(root);
        return max;
    }

    private int maxDepth2(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        int curMax = 1 + Math.max(leftDepth, rightDepth);
        //关键代码：更新最大值
        max = Math.max(max, leftDepth + rightDepth);
        return curMax;
    }
}
