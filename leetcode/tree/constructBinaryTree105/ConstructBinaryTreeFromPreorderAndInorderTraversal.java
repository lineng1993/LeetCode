package tree.constructBinaryTree105;

import tree.TreeNode;

/**
 * @author lin  2021/12/2 11:27
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildHelper(inorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildHelper(int[] preorder, int p_start, int p_end, int[] inorder, int in_start, int in_end){

        if (p_start == p_end){
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        int rootIndex = 0;
        for (int i = in_start; i < in_end; i++) {
            if (root_val == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        //左节点树数量
        int leftNum = rootIndex - in_start;
        root.left = buildHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, in_start, rootIndex);
        root.right = buildHelper(preorder, p_start + leftNum + 1, p_end, inorder, rootIndex + 1, in_end);
        return root;
    }



}
