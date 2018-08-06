package lwh.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
   输出: 6
   解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Problem_53_MaximumSubArray_Easy {

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int maxSum = nums[0];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if(curSum < 0){
                curSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-3,-4,4};

        System.out.println(maxSubArray(nums));
    }
}
