package array.meetingRooms253;

import java.util.Arrays;

/**
 * @author lin  2022/3/28 20:27
 * 可以参考下 https://labuladong.gitee.io/algo/3/28/101/
 */
public class MeetingRooms {


    public static void main(String[] args) {

        int[][] intervals = {
                {1,10},
                {2,7},
                {3,19},
                {8,12},
                {10,20},
                {11,30}
        };
        System.out.println(new MeetingRooms().minMeetingRooms(intervals));
    }


    public int minMeetingRooms(int[][] intervals) {

        int n = intervals.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        // 扫描过程中的计数器
        int count = 0;
        // 双指针技巧
        int i = 0, j = 0;

        while (i < n) {
            if (begin[i] < end[j]) {
                // 上一个会议没有结束
                count++;
                i++;
            } else {
                // 已经有一个结束的会议了
                count--;
                j++;
            }
        }
        return count;
    }

}
