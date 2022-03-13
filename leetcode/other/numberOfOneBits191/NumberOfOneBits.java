package other.numberOfOneBits191;


/**
 * Easy
 */
public class NumberOfOneBits {

    public static void main(String[] args) {


        System.out.println(new NumberOfOneBits().hammingWeight(-3));
    }

    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32 /* 遍历 int 32 位*/; i++) {

            if ((n & (1 << i)) != 0){

                ret++;
            }
        }
        return ret;
    }
}
