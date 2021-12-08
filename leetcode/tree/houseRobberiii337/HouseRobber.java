package tree.houseRobberiii337;

import tree.TreeNode;

/**
 * Medium
 * @author lin  2021/12/8 11:36
 */
public class HouseRobber {


    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(TreeNode.int2TreeNode(1,2,3,4,5,6,7)));
    }

    public int rob(TreeNode root) {
        /**
         * 一开始的思路：层序遍历，即BFS，
         * 最大值是按层累加，区分奇偶数层(可以跳层)，该方式无法处理
         */
//        if (root == null) return 0;
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int num = 0;
//        int oddMax = 0;
//        int evenMax = 0;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.pollFirst();
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//                if ((num & 1) == 0){
//                    evenMax += node.val;
//                }else {
//                    oddMax += node.val;
//                }
//            }
//            num ++;
//        }
//        return Math.max(oddMax, evenMax);

        /**
         * 解题思路是 DFS。
         * 当前节点是否被打劫，会产生 2 种结果。
         * 如果当前节点被打劫，那么它的孩子节点可以被打劫；
         * 如果当前节点没有被打劫，那么它的孩子节点不能被打劫。按照这个逻辑递归，最终递归到根节点，取最大值输出即可。
         */
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);

    }
    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

}
