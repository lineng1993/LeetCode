package string.compareVersionNumbers165;

/**
 * Medium
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {

        String version = "1.01";
        String version2 = "1.101";
        System.out.println(new CompareVersionNumbers().compareVersion2(version, version2));

    }


    public int compareVersion(String version1, String version2) {

        //一开始思路有点问题：这个题应该整体考虑，不然无止尽的处理小数点分割了
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");


        for (int i = 0; i < v1.length || i < v2.length; i++) {

            int x = 0, y = 0;

            if (i < v1.length){
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length){
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) return 1;
            if (x < y) return -1;
        }
        return 0;
    }

    public int compareVersion2(String version1, String version2) {

        int m = version1.length(), n = version2.length();
        int i = 0, j = 0;
        while (i < m || j < n){

            int x = 0;
            for ( ; i < m && version1.charAt(i) != '.'; i++){
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++;

            int y = 0;
            for ( ; j < n && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }

            j++;
            if (x != y) {
                return x > y ? 1 : -1;
            }

        }

        return 0;
    }
}
