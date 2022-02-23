package greedy.taskScheduler621;

import java.util.Arrays;

/**
 * Medium
 */
public class TaskScheduler {


    public static void main(String[] args) {

        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(new TaskScheduler().leastInterval(tasks, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        //https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/

        int[] buckets = new int[26];
        for (char task : tasks) {
            buckets[task - 'A']++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for(int i = 25; i >= 1; i--){
            if(buckets[i] == buckets[i - 1])
                maxCount++;
            else
                break;
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }

}
