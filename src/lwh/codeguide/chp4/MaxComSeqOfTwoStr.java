package lwh.codeguide.chp4;

import java.util.Scanner;

/**
 * 最长公共子序列,dp[i][j]表示最长公共子序列的长度
 */
public class MaxComSeqOfTwoStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
                System.out.println(0);
                continue;
            }

            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();

            int[][] dp = getDpMatrix(ch1, ch2);

            String maxComSeq = getMaxComSeq(dp, ch1, ch2);

            System.out.println(maxComSeq);
        }
    }

    private static int[][] getDpMatrix(char[] ch1, char[] ch2) {
        int len1 = ch1.length;
        int len2 = ch2.length;

        int[][] dp = new int[len1][len2];

        dp[0][0] = ch1[0] == ch2[0] ? 1 : 0;

        for (int i = 1; i < len1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], ch1[i] == ch2[0] ? 1 : 0);
        }

        for (int j = 1; j < len2; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], ch2[j] == ch1[0] ? 1 : 0);
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (ch1[i] == ch2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp;
    }

    private static String getMaxComSeq(int[][] dp, char[] ch1, char[] ch2) {
        int m = ch1.length - 1;
        int n = ch2.length - 1;

        int maxLen = dp[m][n];
        char[] ch = new char[maxLen];
        int index = maxLen - 1;

        while (index >= 0) {
            if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else {
                ch[index--] = ch1[m];
                m--;
                n--;
            }
        }

        return String.valueOf(ch);
    }
}
