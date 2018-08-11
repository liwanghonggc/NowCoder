package lwh.codeguide.video;

public class Coin {

	public static void main(String[] args) {
		int[] a = {3,5};
		System.out.println(countWays(a, a.length, 2));
	}
	
	public static int countWays(int[] changes, int n, int x) {
        if(changes == null || changes.length == 0 || x < 0){
        	return 0;
        }
        int[][] dp = new int[n][x+1];
        for(int i = 0; i < n; i++){
        	dp[i][0] = 1;
        }
        for(int i = 1; changes[0] * i <= x; i++){
        	dp[0][changes[0]*i] = 1;
        }
        for(int i = 1; i < n; i++){
        	for(int j = 1; j <= x; j++){
        		dp[i][j] = dp[i-1][j];
        		dp[i][j] += j-changes[i] >= 0 ? dp[i][j-changes[i]] : 0;
        	}
        }
        return dp[n-1][x];
    }

}
