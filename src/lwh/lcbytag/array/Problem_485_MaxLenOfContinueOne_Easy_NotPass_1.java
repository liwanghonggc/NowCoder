package lwh.lcbytag.array;

/**
 * @author lwh
 * @date 2020-10-25
 * @desp 最大连续1的个数
 * <p>
 * 给定一个二进制数组, 计算其中最大连续1的个数
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1,所以最大连续1的个数是 3.
 * <p>
 * 来源: 力扣(LeetCode)
 * 链接: https://leetcode-cn.com/problems/max-consecutive-ones
 */
public class Problem_485_MaxLenOfContinueOne_Easy_NotPass_1 {

    public static void main(String[] args) {
        int[] a1 = {1, 1, 0, 1, 1, 1};
        int[] a2 = {1, 0, 1, 1, 0, 1};
        int[] a3 = {1, 1, 1, 0, 0, 1, 1, 1, 1};
        int[] a4 = {1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1};

        System.out.println(findMaxConsecutiveOnes(a1));
        System.out.println(findMaxConsecutiveOnes(a2));
        System.out.println(findMaxConsecutiveOnes(a3));
        System.out.println(findMaxConsecutiveOnes(a4));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int count = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxLen = Math.max(maxLen, count);
                count = 0;

            }
        }
        return Math.max(maxLen, count);
    }

}
