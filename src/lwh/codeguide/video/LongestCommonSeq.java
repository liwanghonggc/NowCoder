package lwh.codeguide.video;

import java.util.Scanner;

public class LongestCommonSeq {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] str = line.split(" ");
            int maxLen = getMaxLen(str[0], str[1]);
            System.out.println(maxLen);
        }
    }

    private static int getMaxLen(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < len1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], s1.charAt(i) == s2.charAt(0) ? 1 : 0);
        }
        for (int i = 1; i < len2; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], s2.charAt(i) == s1.charAt(0) ? 1 : 0);
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

}
