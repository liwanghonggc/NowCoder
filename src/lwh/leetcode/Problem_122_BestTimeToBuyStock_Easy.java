package lwh.leetcode;

public class Problem_122_BestTimeToBuyStock_Easy {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxSumProfit = 0;
        int i = 0, j = 1;
        int len = prices.length;

        while (j < len) {
            if (prices[j] <= prices[i]) {
                i = j;
                j++;
                continue;
            }
            if (j == len - 1) {
                int temp = prices[j] - prices[i];
                maxSumProfit += temp;
            } else {
                if (prices[j + 1] > prices[j]) {
                    j++;
                    continue;
                } else {
                    maxSumProfit += prices[j] - prices[i];
                }
            }
            i = j + 1;
            j = j + 2;
        }
        return maxSumProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 5, 3};
        System.out.println(maxProfit(prices));
    }
}
