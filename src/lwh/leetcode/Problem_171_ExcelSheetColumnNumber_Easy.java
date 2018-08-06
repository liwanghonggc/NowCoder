package lwh.leetcode;

public class Problem_171_ExcelSheetColumnNumber_Easy {

    public static int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int res = 0;
        for(int i = 0; i < chs.length; i++){
            int num = chs[i] - 64;
            res += num * Math.pow(26, chs.length - 1 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AZ"));
    }
}
