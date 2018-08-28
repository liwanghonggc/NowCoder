package lwh.PointOffer;


public class Problem47_MaxProfitOfGift {

    public static void main(String[] args) {
        int[][] arr = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(getMaxProfit(arr));
    }

    private static int getMaxProfit(int[][] arr){
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return 0;
        }

        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = arr[0][0];

        for(int i = 1; i < m; i++){
            dp[i][0] = arr[i][0] + dp[i-1][0];
        }

        for(int j = 1; j < n; j++){
            dp[0][j] = arr[0][j] + dp[0][j-1];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = arr[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }
}
