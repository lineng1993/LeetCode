package tree.maximumBinaryTree654;

import tree.TreeNode;

/**
 * @author lin  2021/11/30 14:40
 */
public class MaximumBinaryTree {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {

        if (lo > hi) return null;
        int index = -1,  max = Integer.MIN_VALUE;
        //找到数组最大元素
        for (int i = lo; i <= hi; i++) {
            if (max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }
}
