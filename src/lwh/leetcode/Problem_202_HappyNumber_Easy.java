package lwh.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem_202_HappyNumber_Easy {

    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        while (true) {
            char[] chs = String.valueOf(n).toCharArray();
            int sum = 0;
            for (int i = 0; i < chs.length; i++) {
                int num = chs[i] - 48;
                sum += (num * num);
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
        }

    }

    public static void main(String[] args) {
        System.out.println(isHappy(11));
    }
}
