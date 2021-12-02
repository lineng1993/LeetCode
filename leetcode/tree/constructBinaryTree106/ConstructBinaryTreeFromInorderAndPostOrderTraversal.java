package tree.constructBinaryTree106;

import tree.TreeNode;

/**
 * @author lin  2021/12/2 16:36
 */
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildHelper(int[] inorder, int iStart, int iEnd, int[] postorder,  int pStart, int pEnd){

        if (iStart > iEnd){
            return null;
        }
        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (rootVal == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        int leftSize = rootIndex - iStart;
        root.left = buildHelper(inorder, iStart, rootIndex - 1, postorder, pStart, pStart + leftSize - 1);
        root.right = buildHelper(inorder, rootIndex + 1, iEnd, postorder, pStart + leftSize, pEnd -1);
        return root;
    }


}
