package lwh.codeguide.chp4;

import java.util.Scanner;

/**
 * 最长公共子串,dp[i][j]表示把str1[i]和str2[j]当做公共子串的最后一个字符下,公共子串最多能有多长
 */
public class MaxComStrOfTwoStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
                System.out.println(0);
                continue;
            }

            int[][] dp = getDpMatrix(str1, str2);

            String maxLenStr = getMaxLen(dp, str1);

            System.out.println(maxLenStr);

        }
    }

    private static int[][] getDpMatrix(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1][len2];

        for(int i = 0; i < len1; i++){
            if(str1.charAt(i) == str2.charAt(0)){
                dp[i][0] = 1;
            }
        }

        for(int j = 0; j < len2; j++){
            if(str1.charAt(0) == str2.charAt(j)){
                dp[0][j] = 1;
            }
        }

        for(int i = 1; i < len1; i++){
            for(int j = 1; j < len2; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        return dp;
    }

    private static String getMaxLen(int[][] dp, String str1) {
        int max = 0;
        int len1 = dp.length;
        int len2 = dp[0].length;
        int end = 0;

        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(dp[i][j] > max){
                    end = i;
                    max = dp[i][j];
                }
            }
        }

        return str1.substring(end - max + 1, end + 1);
    }
}
