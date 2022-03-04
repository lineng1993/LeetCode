package greedy.gasStation134;

/**
 * Medium
 * @author lin  2022/3/4 08:56
 */
public class GasStation {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        //暴力解法
        //考虑从第 0 个点出发，能否回到第 0 个点。
        //考虑从第 1 个点出发，能否回到第 1 个点。
        //考虑从第 2 个点出发，能否回到第 2 个点。
        //能回来的条件是什么？剩下的油 >= cost;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i]; //初始值
            while (remain - cost[j] >= 0){

                remain = remain - cost[j] + gas[(j + 1) % n];

                j = (j + 1) % n;

                if (j == i){ //回到原点
                    return i;
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost){
        /*
         * 如果消耗 > 补充，显然无法满足
         */
        int n = gas.length;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += gas[i] - cost[i];
        }

        if(sum < 0){
            return -1;
        }
        // 和为正数，肯定可以，排除法找到对应的index；
        int currentGas = 0;
        int start = 0;
        for(int i = 0;i < n;i++){
            currentGas += gas[i] - cost[i];
            if(currentGas < 0){
                currentGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
