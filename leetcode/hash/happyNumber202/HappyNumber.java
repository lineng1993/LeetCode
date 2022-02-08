package hash.happyNumber202;

import java.util.HashSet;
import java.util.Set;

/**
 * Easy
 * @author lin  2022/2/8 下午4:41
 */
public class HappyNumber {


    public static void main(String[] args) {

        System.out.println(new HappyNumber().isHappy(19));
    }


    public boolean isHappy(int n) {

        Set<Integer> sumSet = new HashSet<>();
        while (true){
            int sum = getSum(n);
            if (sum == 1){
                return true;
            }
            if (sumSet.contains(sum)){
                return false;
            }
            sumSet.add(sum);
            n = sum;
        }
    }

    private int getSum(int n){
        int sum = 0;
        while (n > 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

}
