package lwh.lcbytag.array;

/**
 * @author lwh
 * @date 2020-10-25
 * @desp 子数组最大平均数 I
 * <p>
 * 给定 n 个整数,找出平均数最大且长度为 k 的连续子数组,并输出该最大平均数.
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * <p>
 * 注意:
 * <p>
 * 1 <= k <= n <= 30,000.
 * 所给数据范围 [-10,000,10,000].
 * <p>
 * 来源：力扣(LeetCode)
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 */
public class Problem_643_MaxAvgOfSubArray_Easy_NotPass {

    public static void main(String[] args) {
        int[] a1 = {1, 12, -5, -6, 50, 3};
        int[] a2 = {1, 2, 3, 4, 5, 6};
        int[] a3 = {7, 6, 5, 4, 3, 2};

        System.out.println(findMaxAverage(a1, 4));
        System.out.println(findMaxAverage(a2, 4));
        System.out.println(findMaxAverage(a3, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0;
        if (nums == null || nums.length < k) {
            return maxAvg;
        }

        double temp = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxAvg = sum / k;

        for (int i = 1; i <= nums.length - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            temp = sum / k;
            maxAvg = Math.max(temp, maxAvg);
        }

        return maxAvg;
    }
}
