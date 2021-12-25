package array.intersectionOfTwoArrays349;


import java.util.*;

/**
 * Easy
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] num1 = {1,2,2,3};
        int[] num2 = {2,3,4,5,6};
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(num1, num2)));

    }


    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int n1 : nums1) {
            if (visited.contains(n1)){
                continue;
            }
            for (int n2 : nums2){
                if (n1 == n2){
                    res.add(n1);
                    break;
                }
            }
            visited.add(n1);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;

    }
}
