package tree.convertSortedArrayToBinarySearchTree108;

import tree.TreeNode;

/**
 * Easy
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * @author lin  2021/12/7 09:42
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {

        //基本思路：找到root（高度平衡意味着是中间节点）
        //函数定义设计：nums每次需要拷贝（golang切片每次会重新生成，使用go时不用每次携带nums）,那么需要标识起始和终止位置
        /*
         * golang 切片解法
         * func sortedArrayToBST(nums []int) *TreeNode {
         * 	if len(nums) == 0 {
         * 		return nil
         *        }
         * 	return &TreeNode{Val: nums[len(nums)/2], Left: sortedArrayToBST(nums[:len(nums)/2]), Right: sortedArrayToBST(nums[len(nums)/2+1:])}
         * }
         */
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        //终止条件：start > end,可以相等，相等意味着是叶子节点
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, 0, mid - 1);
        root.right = build(nums, mid + 1, end);
        return root;
    }


}
