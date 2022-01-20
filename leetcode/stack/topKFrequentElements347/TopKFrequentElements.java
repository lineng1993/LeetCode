package stack.topKFrequentElements347;

import java.util.*;

/**
 * Medium
 * @author lin  2022/1/20 11:47
 */
public class TopKFrequentElements {


    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums, 2)));
    }


    public int[] topKFrequent(int[] nums, int k) {


        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个大顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
