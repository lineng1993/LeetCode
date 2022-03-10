package other.pascalsTriangle118;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Easy
 */
public class PascalsTriangle {


    public static void main(String[] args) {

        System.out.println(new PascalsTriangle().generate(5));
    }


    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if (numRows >= 1){
            res.add(Arrays.asList(1));
        }
        if (numRows >= 2){
            res.add(Arrays.asList(1, 1));
        }
        for (int i = 2; i < numRows; i++) {

            List<Integer> rows = new ArrayList<>(i + 1);
            rows.add(1);
            List<Integer> pre = res.get(i - 1);
            for (int j = 1; j < i; j++) {
                rows.add(pre.get(j - 1) + pre.get(j));
            }
            rows.add(1);
            res.add(rows);
        }
        return res;

    }

    public List<List<Integer>> generate2(int numRows) {


        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;

    }

}
