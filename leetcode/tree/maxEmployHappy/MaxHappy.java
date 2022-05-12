package tree.maxEmployHappy;

import javax.sound.sampled.DataLine.Info;
import java.util.List;

/**
 * @author lin  2022/5/12 14:39
 * B 站左神
 * 这个题就是打家劫舍多叉树版 可以不使用Info 使用数组
 */
public class MaxHappy {


    public static class Employer{

        private final int happyVal;
        private final List<Employer> sub;

        public Employer(int happyVal, List<Employer> sub) {
            this.happyVal = happyVal;
            this.sub = sub;
        }

        public int getHappyVal() {
            return happyVal;
        }

        public List<Employer> getSub() {
            return sub;
        }
    }

    public static class Info{
        private final int joinMaxHappy;
        private final int notJoinMaxHappy;

        public Info(int joinMaxHappy, int notJoinMaxHappy) {
            this.joinMaxHappy = joinMaxHappy;
            this.notJoinMaxHappy = notJoinMaxHappy;
        }

        public int getJoinMaxHappy() {
            return joinMaxHappy;
        }

        public int getNotJoinMaxHappy() {
            return notJoinMaxHappy;
        }
    }


    public int maxHappy(Employer boss){
        Info bossInfo = process(boss);
        return Math.max(bossInfo.getJoinMaxHappy(), bossInfo.getNotJoinMaxHappy());
    }

    private Info process(Employer boss){
        if (boss.sub.isEmpty()) return new Info(boss.getHappyVal(), 0); //基层了
        int join = boss.happyVal;
        int notJoin = 0;
        for (Employer employer : boss.sub) {
            Info nextInfo = process(employer);
            join += nextInfo.getNotJoinMaxHappy();
            notJoin += Math.max(nextInfo.getJoinMaxHappy(), nextInfo.getNotJoinMaxHappy());
        }
        return new Info(join, notJoin);
    }
}
