package tree.lowestCommonAncestorOfABinaryTree236;

import tree.TreeNode;

/**
 * @author lin  2021/12/1 19:14
 */
public class LCA {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node4.right = node5;
        System.out.println(new LCA().lowestCommonAncestor(root, node3, node4));


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //基础case
        if(root == null) return null;
        //这行代码决定了找到了会返回对应的left,right，才会有后续的判断逻辑
        if (p == root || q == root)
            return root;
        /*
         * 关键在于描述pq都在二叉树中，避免了一个在，一个不再的情况
         * 此时left,right代表什么含义呢？
         * 1. 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
         * 2. 当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
         * 3. 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
         * p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
         * p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
         * 4. 当 left 不为空 ， right 为空 ：与情况 3. 同理；
         */
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        System.out.println("curr:left" + left);
        System.out.println("curr:right" + right);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.

        return root; // 2. if(left != null and right != null)
    }

}
