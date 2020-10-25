package lwh.lcbytag.array;

/**
 * @author lwh
 * @date 2020-10-25
 * @desp 给定一个未经排序的整数数组, 找到最长且 连续递增的子序列,并返回该序列的长度.
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r(l < r)确定,如果对于每个 l <= i < r,
 * 都有 nums[i] < nums[i + 1] ,那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列.
 * <p>
 *  
 * <p>
 * 示例 1: 
 * <p>
 * 输入: nums = [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3.
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的,因为 5 和 7 在原数组里被 4 隔开.
 * 示例 2: 
 * <p>
 * 输入: nums = [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1.
 * <p>
 * 来源: 力扣(LeetCode)
 * 链接: https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 */
public class Problem_674_MaxLenOfContinueUpArray_Pass_Easy_1 {

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 4, 7};
        int[] a2 = {1, 3, 4, 5, 6};
        int[] a3 = {2, 2, 2, 2, 2};
        int[] a4 = {5, 6};
        int[] a5 = {1, 2, 3, 1, 5, 6, 7, 4, 5, 6};
        int[] a6 = {5, 4, 3, 4, 3};

        System.out.println(findLengthOfLCIS(a1));
        System.out.println(findLengthOfLCIS(a2));
        System.out.println(findLengthOfLCIS(a3));
        System.out.println(findLengthOfLCIS(a4));
        System.out.println(findLengthOfLCIS(a5));
        System.out.println(findLengthOfLCIS(a6));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int maxLen = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp++;
            } else {
                maxLen = Math.max(temp, maxLen);
                temp = 1;
            }
        }
        return Math.max(temp, maxLen);
    }
}
