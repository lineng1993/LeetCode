package tree.insertIntoABinarySearchTree701;

import tree.TreeNode;

/**
 * Medium
 */
public class InsertIntoABinarySearchTree {
    /**
     * 常规迭代
     */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // root为空时直接创建返回
        if (root == null) {
           return new TreeNode(val);
        }

        TreeNode cur = root;
        TreeNode parent = root; // cur == null 时找不到指针了，记录最后一个节点，往上挂val 节点
        while (cur != null){
            parent = cur;
            if (cur.val > val){
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val > val){
            parent.left = node;
        }else {
            parent.right = node;
        }
        return root;
    }
    /**
     * 递归解法
     */

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        // 为null了说明已经到了子节点，需要创建返回了
        if (root == null){
            return new TreeNode(val);
        }
        if (val < root.val){
            root.left = insertIntoBST(root.left, val);
        }else {
            root.right = insertIntoBST(root.right, val);
        }
        //最后返回 root
        return root;
    }

}
