package tree.findModeInBinarySearchTree501;


import tree.TreeNode;

import java.util.*;

/**
 * Easy
 */
public class FindModeInBinarySearchTree {


    public static void main(String[] args) {


        TreeNode root = TreeNode.int2TreeNode(10, 15, 9, 11, 11);
        System.out.println(Arrays.toString(new FindModeInBinarySearchTree().findMode(root)));
        System.out.println(Arrays.toString(new FindModeInBinarySearchTree().findMode2(root)));

    }



    public int[] findMode(TreeNode root) {

        /**
         * 简单题的解法的话使用额外空间，用map存储，整体下来其实也不简单了
         */

        Map<Integer, Integer> countMap = new HashMap<>();
        traverse(countMap, root);

        List<Integer> res = new ArrayList<>();
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            if (maxCount == count){
                res.add(entry.getKey());
            }else if (maxCount < count){
                res.clear();
                maxCount = count;
                res.add(entry.getKey());
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void traverse(Map<Integer, Integer> countMap, TreeNode root){
        if (root == null) return;
        int count = countMap.getOrDefault(root.val, 0);
        countMap.put(root.val, ++count);
        traverse(countMap, root.left);
        traverse(countMap, root.right);
    }


    /**
     * 中序遍历是有序的，可以利用这点
     * @param root
     * @return
     */
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode2(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findModeInorder(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void findModeInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        findModeInorder(root.left);

        int rootValue = root.val;
        // 计数
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果以及maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(rootValue);
        }
        pre = root;


        findModeInorder(root.right);
    }
}
